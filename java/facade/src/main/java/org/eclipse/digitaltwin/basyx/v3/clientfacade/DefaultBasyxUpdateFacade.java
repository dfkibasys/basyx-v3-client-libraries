/*******************************************************************************
 * Copyright (C) 2024 DFKI GmbH (https://www.dfki.de/en/web)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * SPDX-License-Identifier: MIT
 ******************************************************************************/
package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import java.util.List;

import org.apache.http.HttpStatus;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.core.util.AasUtils;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Identifiable;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.BasyxEnvironmentApis;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.BasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.PassThroughBasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxUpdateConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.ConflictingIdentifierException;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.IdentifiableNotFoundException;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.MissingIdentifierException;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.PagedResultPagingMetadata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

class DefaultBasyxUpdateFacade implements BasyxUpdateFacade {

	private BasyxClientCache clientCache;
	private final BasyxEnvironmentApis environmentApis;

	DefaultBasyxUpdateFacade(BasyxEnvironmentApis environmentApis) {
		this.clientCache = new PassThroughBasyxClientCache();
		this.environmentApis = environmentApis;
	}

	DefaultBasyxUpdateFacade(ObjectMapper mapper, BasyxUpdateConfiguration config) {
		this(new BasyxEnvironmentApis(mapper, config));
	}

	DefaultBasyxUpdateFacade withClientCache(BasyxClientCache cache) {
		this.clientCache = cache;
		return this;
	}

	@Override
	public long deleteAllShells() {
		long total = 0;
		String cursor = null;
		do {
			GetAssetAdministrationShellsResult result = this.environmentApis.getShellRepoApi().getAllAssetAdministrationShells(null, null, 10, cursor);
			PagedResultPagingMetadata meta = result.getPagingMetadata();
			if (meta != null) {
				cursor = meta.getCursor();
			}
			List<AssetAdministrationShell> shells = result.getResult();
			if (shells != null) {
				for (AssetAdministrationShell eachShell : shells) {
					deleteShell(eachShell);
					clientCache.invalidateShell(eachShell.getId());
					total++;
				}
			}
		} while (cursor != null);
		return total;
	}

	@Override
	public void deleteShell(AssetAdministrationShell eachShell) {
		this.environmentApis.getShellRepoApi().deleteAssetAdministrationShellById(eachShell.getId());
	}
	
	@Override
	public void deleteShell(String id) {
		this.environmentApis.getShellRepoApi().deleteAssetAdministrationShellById(id);
	}

	@Override
	public long deleteAllSubmodels() {
		long total = 0;
		String cursor = null;
		SubmodelRepositoryApi repoApi = environmentApis.getSubmodelRepoApi();
		do {
			GetSubmodelsResult result = repoApi.getAllSubmodels(null, null, 10, cursor, null, null);
			PagedResultPagingMetadata meta = result.getPagingMetadata();
			if (meta != null) {
				cursor = meta.getCursor();
			}
			List<Submodel> submodels = result.getResult();
			if (submodels == null) {
				continue;
			}
			for (Submodel eachSm : submodels) {
				try {
					deleteSubmodel(eachSm);
					total++;
				} catch (IdentifiableNotFoundException ex) {	
				}
			}
		} while (cursor != null);
		return total;
	}

	@Override
	public void deleteSubmodel(Submodel sm) throws IdentifiableNotFoundException {
		deleteSubmodel(sm.getId());
	}

	@Override
	public void deleteSubmodel(String id) throws MissingIdentifierException, IdentifiableNotFoundException {
		checkId(id);
		try {
			this.environmentApis.getSubmodelRepoApi().deleteSubmodelById(id);
			clientCache.invalidateSubmodel(id);
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_NOT_FOUND) {
				throw new IdentifiableNotFoundException(id);
			}
			throw ex;
		}
	}

	@Override
	public Reference postShell(AssetAdministrationShell shell) throws ConflictingIdentifierException, MissingIdentifierException {
		checkId(shell);
		try {
			AssetAdministrationShell posted = this.environmentApis.getShellRepoApi().postAssetAdministrationShell(shell);
			clientCache.offerLocally(posted);
			return AasUtils.toReference(posted);
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_CONFLICT) {
				throw new ConflictingIdentifierException(shell.getId());
			}
			throw ex;
		}
	}

	@Override
	public Reference updateShell(AssetAdministrationShell shell) throws MissingIdentifierException {
		checkId(shell);
		environmentApis.getShellRepoApi().putAssetAdministrationShellById(shell.getId(), shell);
		clientCache.invalidateShell(shell.getId());
		return AasUtils.toReference(shell);
	}

	@Override
	public Reference postSubmodel(Submodel submodel) throws ConflictingIdentifierException, MissingIdentifierException {
		checkId(submodel);
		try {
			Submodel sm = environmentApis.getSubmodelRepoApi().postSubmodel(submodel);
			Reference ref = AasUtils.toReference(sm);
			clientCache.offerLocally(submodel);
			return ref;
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_CONFLICT) {
				throw new ConflictingIdentifierException(submodel.getId());
			}
			throw ex;
		}
	}

	@Override
	public Reference updateSubmodel(Submodel submodel) throws MissingIdentifierException {
		checkId(submodel);
		Reference ref = AasUtils.toReference(submodel);
		environmentApis.getSubmodelRepoApi().putSubmodelById(submodel.getId(), submodel);
		clientCache.offerLocally(submodel);
		return ref;
	}

	private void checkId(Identifiable identifiable) throws MissingIdentifierException {
		String id = identifiable.getId();
		checkId(id);
	}

	private void checkId(String id) throws MissingIdentifierException {
		if (Strings.isNullOrEmpty(id)) {
			throw new MissingIdentifierException(id);
		}
	}
}
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

import org.apache.http.HttpStatus;
import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.BasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.PassThroughBasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints.EndpointResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints.FirstEndpointResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints.TryAllEndpointResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.references.SimpleSubmodelReferenceResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.references.SubmodelReferenceResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.*;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellDescriptorsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelDescriptorsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.*;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.ShellDescriptorQuery.QueryTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class DefaultBasyxReadFacade implements BasyxReadFacade {


	private EndpointResolver endpointResolver;
	private SubmodelReferenceResolver smReferenceResolver;
	private BasyxClientCache clientCache;

	private final AssetAdministrationShellRegistryApi aasRegistryApi;
	private final SubmodelRegistryApi smRegistryApi;
	private final Integer limit;
	private final BasyxApiManager apiManager;

	public DefaultBasyxReadFacade(BasyxApiManager apiManager) {
		this.apiManager = apiManager;
		aasRegistryApi = apiManager.getShellRegistryApi();
		smRegistryApi = apiManager.getSubmodelRegistryApi();
		this.limit = apiManager.getConfig().getFetchLimit();
		this.endpointResolver = defaultEndpointResolver();
		this.smReferenceResolver = defaultSubmodelReferenceResolver();
		this.clientCache = defaultClientCache();
	}

	protected EndpointResolver defaultEndpointResolver() {
		return new TryAllEndpointResolver(new FirstEndpointResolver());
	}

	protected SubmodelReferenceResolver defaultSubmodelReferenceResolver() {
		return new SimpleSubmodelReferenceResolver();
	}

	protected BasyxClientCache defaultClientCache() {
		return new PassThroughBasyxClientCache();
	}

	@Override
	public DefaultBasyxReadFacade withEndpointResolver(EndpointResolver endpointResolverStrategy) {
		this.endpointResolver = endpointResolverStrategy;
		return this;
	}

	@Override
	public DefaultBasyxReadFacade withSubmodelResolver(SubmodelReferenceResolver smReferenceResolver) {
		this.smReferenceResolver = smReferenceResolver;
		return this;
	}

	DefaultBasyxReadFacade withClientCache(BasyxClientCache cache) {
		this.clientCache = cache;
		return this;
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> getAllShells() throws ApiException {
		return getAllShells(null, null);
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> getAllShells(AssetKind assetKind, String assetType) throws ApiException {
		ResultResolver<String, AssetAdministrationShell> resolver = cursor -> fetchShells(cursor, assetKind, assetType);
		return BasyxIterables.fetchingIterable(resolver);
	}

	@Override
	public BasyxIterable<SubmodelElementInfo> getAllSubmodelElementInfo(Submodel sm) {
		return BasyxIterables.getElementInfoIterable(sm);
	}

	@Override
	public BasyxIterable<Submodel> getAllSubmodels(AssetAdministrationShell shell) {
		if (shell == null) {
			return BasyxIterables.empty();
		}
		List<Reference> submodelRefs = shell.getSubmodels();
		if (submodelRefs == null) {
			return BasyxIterables.empty();
		}
		return BasyxIterables.getMappingNonEmptyIterable(submodelRefs.iterator(), this::getSubmodelByReference);
	}

	@Override
	public Optional<Submodel> getSubmodelByReference(Reference ref) {
		return smReferenceResolver.resolveSubmodel(ref, this::getSubmodelById);
	}

	@Override
	public BasyxIterable<Submodel> getAllSubmodels() {
		ResultResolver<String, Submodel> resolver = cursor -> fetchSubmodels(cursor);
		return BasyxIterables.fetchingIterable(resolver);
	}

	@Override
	public BasyxIterable<SubmodelElement> getAllSubmodelElements(Submodel sm) {
		return BasyxIterables.getMappingIterable(BasyxIterables.getElementInfoIterable(sm).iterator(), SubmodelElementInfo::get);
	}

	@Override
	public BasyxIterable<String> getAllSubmodelElementPaths(Submodel sm) {
		return BasyxIterables.getMappingIterable(BasyxIterables.getElementInfoIterable(sm).iterator(), SubmodelElementInfo::getPath);
	}

	@Override
	public BasyxIterable<Reference> getAllSubmodelElementReferences(Submodel sm) {
		return BasyxIterables.getMappingIterable(BasyxIterables.getElementInfoIterable(sm).iterator(), SubmodelElementInfo::getReference);
	}

	@Override
	public Optional<SubmodelElement> getSubmodelElementByIdShortPath(Submodel sm, String idShortPath) {
		SubmodelElementElementResolver finder = new SubmodelElementElementResolver(idShortPath);
		SubmodelElementWalker walker = new SubmodelElementWalker(finder, new SubmodelElementHierarchyResolver());
		walker.walkSubmodel(sm);
		return finder.result();
	}

	@Override
	public <T extends SubmodelElement> Optional<T> getSubmodelElementByIdShortPath(Submodel sm, String idShortPath, Class<T> resultCls) {
		return getSubmodelElementByIdShortPath(sm, idShortPath).filter(resultCls::isInstance).map(resultCls::cast);
	}

	@Override
	public Optional<AssetAdministrationShell> getShellById(String id) {
		return clientCache.getShellById(id, this::fetchShellById);
	}

	@Override
	public Optional<Submodel> getSubmodelById(String id) {
		return clientCache.getSubmodelById(id, this::fetchSubmodelById);
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> findShellsByIdShort(String idShort) {
		return findShellsByIdShort(idShort, null, null);
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> findShellsByIdShortRegex(String idShortRegex) {
		return findShellsByIdShort(idShortRegex, null, QueryTypeEnum.REGEX);
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> findShellsByIdShort(String idShort, SortDirection direction) {
		return findShellsByIdShort(idShort, new Sorting().direction(direction).addPathItem(SortingPath.IDSHORT), null);
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> findShellsByIdShortRegex(String idShortRegex, SortDirection direction) {
		return findShellsByIdShort(idShortRegex, new Sorting().direction(direction).addPathItem(SortingPath.IDSHORT), QueryTypeEnum.REGEX);
	}

	private BasyxIterable<AssetAdministrationShell> findShellsByIdShort(String idShort, Sorting sorting, QueryTypeEnum queryType) {
		ResultResolver<Integer, AssetAdministrationShell> resultResolver = index -> searchShellsByIdShort(idShort, index, sorting, queryType);
		return BasyxIterables.fetchingIterable(resultResolver);
	}

	private Optional<Submodel> fetchSubmodelById(String id) {
		try {
			SubmodelDescriptor descriptor = smRegistryApi.getSubmodelDescriptorById(id);
			return endpointResolver.resolveSubmodel(apiManager.getMapper(), descriptor.getEndpoints(), this::fetchSubmodelById);
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_NOT_FOUND) {
				return Optional.empty();
			}
			throw ex;
		}
	}

	private Optional<Submodel> fetchSubmodelById(String baseUrl, String id) {
		SubmodelRepositoryApi repoApi = apiManager.getSubmodelRepositoryApi(baseUrl);
		try {
			return Optional.of(repoApi.getSubmodel(id, null, null));
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_NOT_FOUND) {
				return Optional.empty();
			}
			throw ex;
		}
	}

	private BasyxResult<Integer, AssetAdministrationShell> searchShellsByIdShort(String idShort, Integer index, Sorting sorting, QueryTypeEnum queryType) {
		if (index == null) {
			index = 0;
		}
		Page page = new Page().index(index).size(limit);
		ShellDescriptorQuery query = new ShellDescriptorQuery().path("idShort").value(idShort).queryType(queryType);
		ShellDescriptorSearchRequest request = new ShellDescriptorSearchRequest().page(page).sortBy(sorting).query(query);
		ShellDescriptorSearchResponse response = aasRegistryApi.searchShellDescriptors(request);
		int newIndex = ++index;
		int pos = newIndex * limit;
		Integer cursor = pos < response.getTotal() ? newIndex : null;
		List<AssetAdministrationShellDescriptor> hits = response.getHits();
		List<AssetAdministrationShell> toReturn = new ArrayList<>(hits.size());
		for (AssetAdministrationShellDescriptor eachDescriptor : hits) {
			Optional<AssetAdministrationShell> shellOpt = clientCache.getShellByIdIfPresent(idShort);
			if (shellOpt.isEmpty()) {
				shellOpt = endpointResolver.resolveShell(apiManager.getMapper(), eachDescriptor.getEndpoints(), this::fetchShellById);
			}
			shellOpt.ifPresent(toReturn::add);
		}
		return new BasyxResult<>(cursor, toReturn);
	}

	private BasyxResult<String, SubmodelDescriptor> fetchSubmodelDescriptors(String cursor) {
		GetSubmodelDescriptorsResult descriptorResult = smRegistryApi.getAllSubmodelDescriptors(this.limit, cursor);
		List<SubmodelDescriptor> descriptors = descriptorResult.getResult();
		return new BasyxResult<>(descriptorResult.getPagingMetadata().getCursor(), descriptors);
	}

	private BasyxResult<String, Submodel> fetchSubmodels(String cursor) {
		BasyxResult<String, SubmodelDescriptor> descriptorResult = fetchSubmodelDescriptors(cursor);
		List<SubmodelDescriptor> fetchedResult = descriptorResult.result();
		List<Submodel> toReturn = new ArrayList<>(fetchedResult.size());
		for (SubmodelDescriptor eachDescriptor : fetchedResult) {
			Optional<Submodel> sm = endpointResolver.resolveSubmodel(apiManager.getMapper(), eachDescriptor.getEndpoints(), this::fetchSubmodelById);
			if (sm.isPresent()) {
				toReturn.add(sm.get());
			}
		}
		return new BasyxResult<>(descriptorResult.cursor(), toReturn);
	}

	private Optional<AssetAdministrationShell> fetchShellById(String id) {
		try {
			AssetAdministrationShellDescriptor descriptor = aasRegistryApi.getAssetAdministrationShellDescriptor(id);
			return endpointResolver.resolveShell(apiManager.getMapper(), descriptor.getEndpoints(), this::fetchShellById);
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_NOT_FOUND) {
				return Optional.empty();
			}
			throw ex;
		}
	}

	private Optional<AssetAdministrationShell> fetchShellById(String baseUrl, String id) {
		AssetAdministrationShellRepositoryApi api = apiManager.getShellRepositoryApi(baseUrl);
		try {
			return Optional.of(api.getAssetAdministrationShell(id));
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_NOT_FOUND) {
				return Optional.empty();
			}
			throw ex;
		}
	}

	private BasyxResult<String, AssetAdministrationShellDescriptor> fetchShellDescriptors(String cursor, AssetKind assetKind, String assetType) throws ApiException {
		GetAssetAdministrationShellDescriptorsResult result = aasRegistryApi.getAllAssetAdministrationShellDescriptors(limit, cursor, assetKind, assetType);
		return new BasyxResult<>(result.getPagingMetadata().getCursor(), result.getResult());
	}

	private BasyxResult<String, AssetAdministrationShell> fetchShells(String cursor, AssetKind kind, String assetType) throws ApiException {
		BasyxResult<String, AssetAdministrationShellDescriptor> descriptorResult = fetchShellDescriptors(cursor, kind, assetType);
		List<AssetAdministrationShellDescriptor> fetchedResult = descriptorResult.result();
		List<AssetAdministrationShell> toReturn = new ArrayList<>(fetchedResult.size());
		for (AssetAdministrationShellDescriptor eachDescriptor : fetchedResult) {
			Optional<AssetAdministrationShell> shellDescriptorOpt = endpointResolver.resolveShell(apiManager.getMapper(), eachDescriptor.getEndpoints(), this::fetchShellById);
			shellDescriptorOpt.ifPresent(toReturn::add);
		}
		return new BasyxResult<>(descriptorResult.cursor(), toReturn);
	}
}
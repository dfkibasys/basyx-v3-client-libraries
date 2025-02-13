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
package org.eclipse.digitaltwin.basyx.v3.clientfacade.registration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetInformation;
import org.eclipse.digitaltwin.aas4j.v3.model.Endpoint;
import org.eclipse.digitaltwin.aas4j.v3.model.ProtocolInformation;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultEndpoint;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultProtocolInformation;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodelDescriptor;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.BasyxUpdateListener;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiClient;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRegistryApi;

public class RegistratingUpdateListener implements BasyxUpdateListener {

	
	private final AssetAdministrationShellRegistryApi aasRegApi;
	private final SubmodelRegistryApi smRegApi;
	
	private final List<String> aasRepoHrefs;
	private final List<String> smRepoHrefs;
	
	public RegistratingUpdateListener(AssetAdministrationShellRegistryApi aasRegApi, SubmodelRegistryApi smRegApi, List<String> repoHrefs, List<String> smRepoHrefs) {
		this.aasRegApi = aasRegApi;
		this.smRegApi = smRegApi;
		this.aasRepoHrefs = repoHrefs;
		this.smRepoHrefs = smRepoHrefs;
	}
	
	@Override
	public void onPostSubmodelReference(String shellId, Reference reference) {
		// do nothing
	}
	
	@Override
	public void onDeleteSubmodelReference(String aasId, String submodelIdentifier) {
		// do nothing	
	}
	
	@Override
	public void onDeleteShell(AssetAdministrationShell eachShell) {
		aasRegApi.deleteAssetAdministrationShellDescriptor(eachShell.getId());		
	}

	@Override
	public void onDeleteSubmodel(String id) {
		smRegApi.deleteSubmodelDescriptorById(id);		
	}

	@Override
	public void onPostShell(AssetAdministrationShell shell) {
		AssetAdministrationShellDescriptor shellDescr = RegistrationUtils.toAasRepositoryDescriptor(shell, aasRepoHrefs);
		aasRegApi.postAssetAdministrationShellDescriptor(shellDescr);
	}

	@Override
	public void onUpdateShell(AssetAdministrationShell shell) {
		AssetAdministrationShellDescriptor descr = RegistrationUtils.toAasRepositoryDescriptor(shell, aasRepoHrefs);
		aasRegApi.putAssetAdministrationShellDescriptor(descr.getId(), descr);		
	}

	@Override
	public void onPostSubmodel(Submodel submodel) {
		SubmodelDescriptor descriptor = RegistrationUtils.toSubmodelRopositoryDescriptor(submodel, smRepoHrefs);
		smRegApi.postSubmodelDescriptor(descriptor);
	}

	@Override
	public void onUpdateSubmodel(Submodel submodel) {
		SubmodelDescriptor descriptor = RegistrationUtils.toSubmodelRopositoryDescriptor(submodel, smRepoHrefs);
		smRegApi.putSubmodelDescriptorById(descriptor.getId(), descriptor);
	}

}

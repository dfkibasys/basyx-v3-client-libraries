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

	private static final String AAS_INTERFACE = "AAS-3.0";
	
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
	public void onDeleteShell(AssetAdministrationShell eachShell) {
		aasRegApi.deleteAssetAdministrationShellDescriptor(eachShell.getId());		
	}

	@Override
	public void onDeleteSubmodel(String id) {
		smRegApi.deleteSubmodelDescriptorById(id);		
	}

	@Override
	public void onPostShell(AssetAdministrationShell shell) {
		AssetAdministrationShellDescriptor shellDescr = toDescriptor(shell);
		aasRegApi.postAssetAdministrationShellDescriptor(shellDescr);
	}

	@Override
	public void onUpdateShell(AssetAdministrationShell shell) {
		AssetAdministrationShellDescriptor descr = toDescriptor(shell);
		aasRegApi.putAssetAdministrationShellDescriptor(descr.getId(), descr);		
	}

	@Override
	public void onPostSubmodel(Submodel submodel) {
		SubmodelDescriptor descriptor = toDescriptor(submodel);
		smRegApi.postSubmodelDescriptor(descriptor);
	}

	@Override
	public void onUpdateSubmodel(Submodel submodel) {
		SubmodelDescriptor descriptor = toDescriptor(submodel);
		smRegApi.putSubmodelDescriptorById(descriptor.getId(), descriptor);
	}

	protected AssetAdministrationShellDescriptor toDescriptor(AssetAdministrationShell shell) {
		AssetAdministrationShellDescriptor descriptor = new DefaultAssetAdministrationShellDescriptor();
		Optional.ofNullable(shell.getId()).ifPresent(descriptor::setId);
		Optional.ofNullable(shell.getIdShort()).ifPresent(descriptor::setIdShort);
		Optional.of(getEndpoints(shell.getId(), this.aasRepoHrefs)).filter(Predicate.not(List::isEmpty)).ifPresent(descriptor::setEndpoints);
		Optional.ofNullable(shell.getDescription()).ifPresent(descriptor::setDescription);
		Optional.ofNullable(shell.getDisplayName()).ifPresent(descriptor::setDisplayName);
		Optional.ofNullable(shell.getExtensions()).ifPresent(descriptor::setExtensions);
		Optional.ofNullable(shell.getAdministration()).ifPresent(descriptor::setAdministration);
		Optional.ofNullable(shell.getAssetInformation()).map(AssetInformation::getAssetKind).ifPresent(descriptor::setAssetKind);
		Optional.ofNullable(shell.getAssetInformation()).map(AssetInformation::getAssetType).ifPresent(descriptor::setAssetType);
		Optional.ofNullable(shell.getAssetInformation()).map(AssetInformation::getGlobalAssetId).ifPresent(descriptor::setGlobalAssetId);
		return descriptor;
	}
	
	protected SubmodelDescriptor toDescriptor(Submodel sm) {
		SubmodelDescriptor descriptor = new DefaultSubmodelDescriptor();
		Optional.ofNullable(sm.getId()).ifPresent(descriptor::setId);
		Optional.ofNullable(sm.getIdShort()).ifPresent(descriptor::setIdShort);
		Optional.of(getEndpoints(sm.getId(), this.smRepoHrefs)).filter(Predicate.not(List::isEmpty)).ifPresent(descriptor::setEndpoints);
		Optional.ofNullable(sm.getDescription()).ifPresent(sm::setDescription);
		Optional.ofNullable(sm.getDisplayName()).ifPresent(sm::setDisplayName);
		Optional.ofNullable(sm.getExtensions()).ifPresent(sm::setExtensions);
		Optional.ofNullable(sm.getAdministration()).ifPresent(sm::setAdministration);
		Optional.ofNullable(sm.getSemanticId()).ifPresent(sm::setSemanticId);
		Optional.ofNullable(sm.getSupplementalSemanticIds()).filter(Predicate.not(List::isEmpty)).ifPresent(descriptor::setSupplementalSemanticId);
		return descriptor;
	}
	
	private List<Endpoint> getEndpoints(String id, List<String> hrefs) {
		List<Endpoint> endpoints = new LinkedList<>();
		for (String eachUrl : hrefs) {
			Endpoint ep = createEndpointItem(eachUrl, id);
			endpoints.add(ep);
		}
		return endpoints;
	}

	private Endpoint createEndpointItem(String url, String shellId) {
		Endpoint endpoint = new DefaultEndpoint();
		endpoint.set_interface(AAS_INTERFACE);
		ProtocolInformation protocolInformation = createProtocolInformation(url, shellId);
		endpoint.setProtocolInformation(protocolInformation);
		return endpoint;
	}
	
	private ProtocolInformation createProtocolInformation(String url, String shellId) {
		String href = url + "/" + ApiClient.base64UrlEncode(shellId);
		ProtocolInformation protocolInformation = new DefaultProtocolInformation();
		protocolInformation.setEndpointProtocol(getProtocol(href));
		protocolInformation.setHref(href);
		return protocolInformation;
	}
	
	private String getProtocol(String endpoint) {
		try {
			return new URL(endpoint).getProtocol();
		} catch (MalformedURLException e) {
			throw new RuntimeException();
		}
	}
}

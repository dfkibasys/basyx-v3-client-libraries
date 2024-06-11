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
package org.eclipse.digitaltwin.basyx.v3.clientfacade.util;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetInformation;
import org.eclipse.digitaltwin.aas4j.v3.model.Endpoint;
import org.eclipse.digitaltwin.aas4j.v3.model.ProtocolInformation;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultEndpoint;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultProtocolInformation;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiClient;

public class PassThroughAasDescriptorFactory {

	private static final String AAS_INTERFACE = "AAS-3.0";
	private static final String AAS_REPOSITORY_PATH = "shells";

	private final List<String> aasRepositoryURLs;


	public PassThroughAasDescriptorFactory(List<String> aasRepositoryBaseURLs) {
		super();
		this.aasRepositoryURLs = createAasRepositoryUrls(aasRepositoryBaseURLs);
		
	}

	public AssetAdministrationShellDescriptor create(AssetAdministrationShell shell) {

		AssetAdministrationShellDescriptor descriptor = new DefaultAssetAdministrationShellDescriptor();
		
		Optional.ofNullable(shell.getId()).ifPresent(descriptor::setId);
		Optional.ofNullable(shell.getIdShort()).ifPresent(descriptor::setIdShort);
		
		applyEndpointItems(shell.getId(), descriptor);
		
		Optional.ofNullable(shell.getDescription()).filter(Predicate.not(List::isEmpty)).ifPresent(descriptor::setDescription);
		Optional.ofNullable(shell.getDisplayName()).filter(Predicate.not(List::isEmpty)).ifPresent(descriptor::setDisplayName);
		Optional.ofNullable(shell.getExtensions()).filter(Predicate.not(List::isEmpty)).ifPresent(descriptor::setExtensions);
		Optional.ofNullable(shell.getAdministration()).ifPresent(descriptor::setAdministration);
		Optional.ofNullable(shell.getAssetInformation()).map(AssetInformation::getAssetKind).ifPresent(descriptor::setAssetKind);
		Optional.ofNullable(shell.getAssetInformation()).map(AssetInformation::getAssetType).ifPresent(descriptor::setAssetType);
		Optional.ofNullable(shell.getAssetInformation()).map(AssetInformation::getGlobalAssetId).ifPresent(descriptor::setGlobalAssetId);

		return descriptor;
	}
	
	private void applyEndpointItems(String shellId, AssetAdministrationShellDescriptor descriptor) {
		List<Endpoint> endpoints = new ArrayList<>();
		for (String eachUrl : aasRepositoryURLs) {
			Endpoint ep = createEndpointItem(eachUrl, shellId);
			endpoints.add(ep);
		}
		descriptor.setEndpoints(endpoints);
	}

	private Endpoint createEndpointItem(String url, String shellId) {
		Endpoint endpoint = new DefaultEndpoint();
		endpoint.set_interface(AAS_INTERFACE);
		ProtocolInformation protocolInformation = createProtocolInformation(url, shellId);
		endpoint.setProtocolInformation(protocolInformation);
		return endpoint;
	}

	private ProtocolInformation createProtocolInformation(String url, String shellId) {
		String href = url + "/" + ApiClient.urlEncode(shellId);
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

	private List<String> createAasRepositoryUrls(List<String> aasRepositoryBaseURLs) {
		List<String> repositoryUrls = new ArrayList<String>(aasRepositoryBaseURLs.size());
		for (String eachUrl : aasRepositoryBaseURLs) {
			try {
				String url = new URL(new URL(eachUrl), AAS_REPOSITORY_PATH).toString();
				repositoryUrls.add(url);
			} catch (MalformedURLException e) {
				throw new RuntimeException("The AAS Repository Base url is malformed.\n" + e.getMessage());
			}
		}
		return repositoryUrls;
	}

}

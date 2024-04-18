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
package org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Endpoint;
import org.eclipse.digitaltwin.aas4j.v3.model.ProtocolInformation;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractEndpointResolver implements EndpointResolver {

	@Override
	public Optional<AssetAdministrationShell> resolveShell(ObjectMapper mapper, List<Endpoint> endpoints, IdentifiableResolver<AssetAdministrationShell> shellResolver) {
		if (endpoints == null || endpoints.isEmpty()) {
			return Optional.empty();
		}
		Endpoint endpoint = chooseEndpoint(endpoints);
		if (endpoint == null) {
			return Optional.empty();
		}
		EndpointParser parser = EndpointParser.forShells();
		EndpointParser.EndpointInfo info = parser.parse(endpoint);	
		return shellResolver.resolve(info.getServerPart(), info.getIdPartDecoded());
	}
	
	@Override
	public Optional<Submodel> resolveSubmodel(ObjectMapper mapper, List<Endpoint> endpoints, IdentifiableResolver<Submodel> submodelResolver) {
		if (endpoints == null || endpoints.isEmpty()) {
			return Optional.empty();
		}
		Endpoint endpoint = chooseEndpoint(endpoints);
		if (endpoint == null) {
			return Optional.empty();
		}
		EndpointParser parser = EndpointParser.forSubmodels();
		EndpointParser.EndpointInfo info = parser.parse(endpoint);	
		return submodelResolver.resolve(info.getServerPart(), info.getIdPartDecoded());
	}
	
	abstract Endpoint chooseEndpoint(List<Endpoint> endpoints);
		
	private static class EndpointParser {
		
		private final static String SHELLS_SEPARATOR = "/shells/";
		private final static String SUBMODELS_SEPARATOR = "/submodels/";
		
		private final String serverIdSeparator;
		
		private EndpointParser(String serverIdSeparator) {
			this.serverIdSeparator = serverIdSeparator;
		}
		
		public static EndpointParser forShells() {
			return new EndpointParser(SHELLS_SEPARATOR);
		}
		
		public static EndpointParser forSubmodels() {
			return new EndpointParser(SUBMODELS_SEPARATOR);
		}
		
		
		private EndpointInfo parse(Endpoint endpoint) {
			ProtocolInformation info = endpoint.getProtocolInformation();
			if (info == null) {
				throw new ApiException("ProtocolInformation not set");
			}
			String href = info.getHref();
			if (href == null) {
				throw new ApiException("Href not set");
			}
			String[] split = href.split(serverIdSeparator);
			if (split.length != 2) {
				throw new ApiException("Href reference format not supported " + href);
			}
			return new EndpointInfo(split[0], split[1]);
		}
		
		public static class EndpointInfo {

			private final String serverPart;
			private final String idPart;
					
			public EndpointInfo(String serverPart, String idPart) {
				this.serverPart = serverPart;
				this.idPart = idPart;
			}
			
			public String getServerPart() {
				return serverPart;
			}
			
			public String getIdPart() {
				return idPart;
			}
			
			public String getIdPartDecoded() {
				return new String(Base64.getUrlDecoder().decode(getIdPart()), StandardCharsets.UTF_8);	
			}
		}
	}	
}

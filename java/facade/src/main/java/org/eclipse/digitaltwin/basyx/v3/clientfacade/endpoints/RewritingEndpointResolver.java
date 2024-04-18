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

import java.util.List;
import java.util.Optional;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Endpoint;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RewritingEndpointResolver extends AbstractEndpointResolver {

	private final AbstractEndpointResolver resolver;
	private final EndpointRewritingStrategy strategy;
	
	public RewritingEndpointResolver(AbstractEndpointResolver resolver, EndpointRewritingStrategy strategy) {
		this.resolver = resolver;
		this.strategy = strategy;
	}
	
	@Override
	protected Endpoint chooseEndpoint(List<Endpoint> endpoints) {
		Endpoint ep = resolver.chooseEndpoint(endpoints);
		return strategy.rewriteEndpoint(ep);
	}
	
	@Override
	public Optional<AssetAdministrationShell> resolveShell(ObjectMapper mapper, List<Endpoint> endpoints, IdentifiableResolver<AssetAdministrationShell> shellResolver) {
		return resolver.resolveShell(mapper, endpoints, shellResolver);
	}
	
	@Override
	public Optional<Submodel> resolveSubmodel(ObjectMapper mapper, List<Endpoint> endpoints, IdentifiableResolver<Submodel> submodelResolver) {
		return resolver.resolveSubmodel(mapper, endpoints, submodelResolver);
	}
}
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
package org.eclipse.digitaltwin.basyx.v3.clientfacade.api;

import java.net.http.HttpClient;

import org.eclipse.digitaltwin.basyx.v3.clientfacade.intercept.BasyxTransferInterceptor;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiClient;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AasxFileServerApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRepositoryApi;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DefaultBasyxApiFactory implements BasyxApiFactory {

	private final BasyxTransferInterceptor interceptor;
	
	public DefaultBasyxApiFactory(BasyxTransferInterceptor interceptor) {
		this.interceptor = interceptor;
	}
	
	@Override
	public AssetAdministrationShellRegistryApi newShellRegistryApi(ObjectMapper mapper, String baseUrl) {
		return new AssetAdministrationShellRegistryApi(newClient(mapper, baseUrl));
	}

	@Override
	public SubmodelRegistryApi newSubmodelRegistryApi(ObjectMapper mapper, String baseUrl) {
		return new SubmodelRegistryApi(newClient(mapper, baseUrl));
	}

	@Override
	public AssetAdministrationShellRepositoryApi newShellRepositoryApi(ObjectMapper mapper, String baseUrl) {
		return new AssetAdministrationShellRepositoryApi(newClient(mapper, baseUrl));
	}

	@Override
	public SubmodelRepositoryApi newSubmodelRepositoryApi(ObjectMapper mapper, String baseUrl) {
		return new SubmodelRepositoryApi(newClient(mapper, baseUrl));
	}
	
	@Override
	public AasxFileServerApi newAasxFileServerApi(ObjectMapper mapper, String baseUrl) {
		return new AasxFileServerApi(newClient(mapper, baseUrl));
	}
	
	private ApiClient newClient(ObjectMapper mapper, String url) {
		HttpClient.Builder builder = HttpClient.newBuilder();
		ApiClient client = new ApiClient(builder, mapper, url);
		if (interceptor != null) {
			interceptor.init(url, builder);
			client.setRequestInterceptor(b->interceptor.onRequest(url, b));
			client.setResponseInterceptor(r->interceptor.onResponse(url, r));
		}
		return client;
	}
}

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
package org.eclipse.digitaltwin.basyx.v3.clientfacade.main;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.*;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.BasyxApiFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.DefaultBasyxApiFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxApiConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxRegistryServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.SimpleBasyxApiConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.SimpleBasyxServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.DefaultBasyxAuthorizationInterceptor;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.ServiceAccountAuthorizer;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.config.ClientCredentialsAuthorizerConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.config.DefaultClientCredentialsAuthorizerConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clients.JSON;

public class AuthorizationMain {

	public static void main(String[] args) {
		
		ClientCredentialsAuthorizerConfiguration authConfig = new DefaultClientCredentialsAuthorizerConfiguration()
					.withIssuerUrl("http://localhost:8085")
					.withRealm("EclipseBaSyx")
					.withClientId("basyx-read-only-client")
					.withClientSecret("UlgasH8YxcIoQYJyjfa8IVqac7xLOcvn");
		ServiceAccountAuthorizer authorizer = new ServiceAccountAuthorizer(authConfig);
		DefaultBasyxAuthorizationInterceptor interceptor = new DefaultBasyxAuthorizationInterceptor(authorizer);
		BasyxApiFactory apiFactory = new DefaultBasyxApiFactory(interceptor);

		BasyxApiConfiguration conf = new SimpleBasyxApiConfiguration()
				.withAasRegistryUrl("http://127.0.0.1:8083")
				.withSubmodelRegistryUrl("http://127.0.0.1:8082");

		BasyxApiManager apiManager = new DefaultBasyxApiManager(conf, JSON.getDefault().getMapper(), apiFactory);
		BasyxFacadeManager manager = new DefaultBasyxFacadeManager(apiManager);

		BasyxReadFacade readFacade = manager.newReadFacade();
		while (true) {
			readFacade.getAllShells().stream().map(AssetAdministrationShell::getId).forEach(System.out::println);
		}

		//BasyxUpdateConfiguration updateConfig = SimpleBasyxUpdateConfiguration.forEnvironmentUrl("http://127.0.0.1:8081");
		//BasyxUpdateFacade updateFacade = manager.newUpdateFacade(updateConfig);
		
		//updateFacade.deleteAllShells();
	}

}

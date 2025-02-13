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
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodel;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.*;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.*;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints.EndpointResolvers;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.ConflictingIdentifierException;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.references.SimpleSubmodelReferenceResolver;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {

	public static void main(String[] args) throws ConflictingIdentifierException, JsonProcessingException, ApiException {

		BasyxApiConfiguration conf = new SimpleBasyxApiConfiguration()
				.withEnvironmentUrl("http://127.0.0.1:8081")
				.withAasRegistryUrl("http://127.0.0.1:8083")
				.withSubmodelRegistryUrl("http://127.0.0.1:8082");
		BasyxApiManager apiManager = new DefaultBasyxApiManager(conf);
		BasyxFacadeManager manager = new DefaultBasyxFacadeManager(apiManager);

		BasyxWriteFacade writeFacade = manager.newWriteFacade();

		manager.newReadFacade().getAllShells().stream().map(AssetAdministrationShell::getId).forEach(System.out::println);
		
		writeFacade.deleteAllShells();
		writeFacade.deleteAllSubmodels();
		
		Reference ref = writeFacade.postSubmodel(new DefaultSubmodel.Builder().id("http://sm.test.org/test-sm").idShort("test-sm").build());
		writeFacade.postShell(new DefaultAssetAdministrationShell.Builder().id("http://aas.test.org/test-aas").idShort("test-aas").submodels(ref).build());
		
		BasyxReadFacade facade = manager.newReadFacade().withEndpointResolver(EndpointResolvers.firstWithAddress("127.0.0.1:8081"))
				.withSubmodelResolver(new SimpleSubmodelReferenceResolver());
		for (AssetAdministrationShell eachShell : facade.getAllShells()) {
			System.out.println(eachShell.getId());
			for (Submodel eachSm : facade.getAllSubmodels(eachShell)) {
				System.out.println(eachSm.getId());
			}
		}
		writeFacade.deleteAllShells();
		writeFacade.deleteAllSubmodels();
	}

}

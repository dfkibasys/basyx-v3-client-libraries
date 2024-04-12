package org.eclipse.gigitaltwin.basyx.v3.clientfacade;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.gigitaltwin.basyx.v3.clientfacade.config.BasyxServiceConfiguration;
import org.eclipse.gigitaltwin.basyx.v3.clientfacade.config.SimpleBasyxServiceConfiguration;
import org.eclipse.gigitaltwin.basyx.v3.clientfacade.endpoints.EndpointResolvers;
import org.eclipse.gigitaltwin.basyx.v3.clientfacade.references.SimpleSubmodelReferenceResolver;

public class Main {

	public static void main(String[] args) {
		
		BasyxServiceConfiguration config = new SimpleBasyxServiceConfiguration().withAasRegistryUrl("http://127.0.0.1:8082").withSubmodelRegistryUrl("http://127.0.0.1:8083");
		
		BasyxServiceFacade facade = new BasyxServiceFacade(config)
				.withEndpointResolver(EndpointResolvers.firstWithAddress("127.0.0.1:8081"))
				.withSubmodelResolver(new SimpleSubmodelReferenceResolver());
		for (AssetAdministrationShell eachShell : facade.getAllShells()) {
			System.out.println(eachShell.getId());
			for (Submodel eachSm : facade.getAllSubmodels(eachShell)) {
				System.out.println(eachSm.getId());
			}
		}
		
	}

}

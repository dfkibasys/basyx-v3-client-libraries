package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodel;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxRegistryServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxUpdateConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.SimpleBasyxServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.SimpleBasyxUpdateConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints.EndpointResolvers;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.ConflictingIdentifierException;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.references.SimpleSubmodelReferenceResolver;

public class Main {

	public static void main(String[] args) throws ConflictingIdentifierException {
		
		BasyxConnectionManager manager = new DefaultBasyxConnectionManager();
		
		BasyxUpdateConfiguration updateConfig = SimpleBasyxUpdateConfiguration.forEnvironmentUrl("http://127.0.0.1:8081");
		BasyxUpdateFacade updateFacade = manager.newUpdateFacade(updateConfig);
		updateFacade.deleteAllShells();
		updateFacade.deleteAllSubmodels();
		
		Reference ref = updateFacade.postSubmodel(new DefaultSubmodel.Builder().id("http://sm.test.org/test-sm").idShort("test-sm").build());
		updateFacade.postShell(new DefaultAssetAdministrationShell.Builder().id("http://aas.test.org/test-aas").idShort("test-aas").submodels(ref).build());
		
		BasyxRegistryServiceConfiguration serviceConfig = new SimpleBasyxServiceConfiguration().withAasRegistryUrl("http://127.0.0.1:8083").withSubmodelRegistryUrl("http://127.0.0.1:8082");
		BasyxServiceFacade facade = manager.newServiceFacade(serviceConfig).withEndpointResolver(EndpointResolvers.firstWithAddress("127.0.0.1:8081"))
				.withSubmodelResolver(new SimpleSubmodelReferenceResolver());
		for (AssetAdministrationShell eachShell : facade.getAllShells()) {
			System.out.println(eachShell.getId());
			for (Submodel eachSm : facade.getAllSubmodels(eachShell)) {
				System.out.println(eachSm.getId());
			}
		}
		updateFacade.deleteAllShells();
		updateFacade.deleteAllSubmodels();
		
	}

}

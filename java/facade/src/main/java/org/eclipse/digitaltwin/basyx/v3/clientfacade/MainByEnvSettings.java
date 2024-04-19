package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import java.util.List;
import java.util.stream.StreamSupport;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.DataTypeDefXsd;
import org.eclipse.digitaltwin.aas4j.v3.model.Entity;
import org.eclipse.digitaltwin.aas4j.v3.model.Property;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetAdministrationShell.Builder;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultEntity;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultProperty;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodel;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.CaffeineBasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints.EndpointResolvers;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.ConflictingIdentifierException;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxIterable;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxIterables;

import com.fasterxml.jackson.core.JsonProcessingException;

public class MainByEnvSettings {

	public static void main(String[] args) throws JsonProcessingException, ConflictingIdentifierException {
				
		BasyxConnectionManager manager = new DefaultBasyxConnectionManager();
		manager.withClientCache(new CaffeineBasyxClientCache());
		
		BasyxUpdateFacade updateFacade = manager.newUpdateFacade();
		updateFacade.deleteAllShells();
		updateFacade.deleteAllSubmodels();
		postShells(updateFacade);
		
		BasyxServiceFacade facade = manager.newServiceFacade()
				.withEndpointResolver(EndpointResolvers.firstWithAddress("127.0.0.1:8081"));

		AssetAdministrationShell shell = facade.getShellById("http://aas.test.org/robot/5").get();
		System.out.println(shell.getIdShort());
		for (Submodel eachSm : facade.getAllSubmodels(shell)) {
			System.out.println(manager.toJsonPretty(eachSm));
			facade.getAllSubmodelElementPaths(eachSm).stream().forEach(System.out::println);
			System.out.println(facade.getSubmodelElementByIdShortPath(eachSm, "robot.height", Property.class).get().getValue());

		}
		facade.getAllSubmodels(shell).stream().map(Submodel::getKind).forEach(System.err::println);

		facade.findShellsByIdShortRegex("^robot-.*[3|4|5]$").stream().map(AssetAdministrationShell::getId).forEach(System.out::println);
		
		for (Submodel eachSm : facade.getAllSubmodels()) {
			System.out.println(eachSm.getId());
			
		}
		
		facade.getSubmodelById("http://sm.test.org/technical/9/6").map(facade::getAllSubmodelElementReferences).stream().flatMap(BasyxIterable::stream).map(manager::toJsonPretty).forEach(System.out::println);
		
		updateFacade.deleteAllShells();
		updateFacade.deleteAllSubmodels();
		
	}

	private static void postShells(BasyxUpdateFacade updateFacade) throws ConflictingIdentifierException {
		for (int i = 0; i < 10; i++) {
			Builder builder = new DefaultAssetAdministrationShell.Builder().id("http://aas.test.org/robot/" + i).idShort("robot-"+i);
			for (int j = 0; j < 10; j++) {
				Property height = new DefaultProperty.Builder().idShort("height").valueType(DataTypeDefXsd.INT).value("200").build();
				Property width = new DefaultProperty.Builder().idShort("width").valueType(DataTypeDefXsd.INT).value("33").build();
				Entity entity = new DefaultEntity.Builder().idShort("robot").statements(List.of(height, width)).build();
				Submodel sm = new DefaultSubmodel.Builder().id("http://sm.test.org/technical/"+i +"/" +j).idShort("technical").submodelElements(entity).build();
				Reference ref = updateFacade.postSubmodel(sm);
				builder.submodels(ref);
			}
			updateFacade.postShell(builder.build());
		}		
	}

	
}

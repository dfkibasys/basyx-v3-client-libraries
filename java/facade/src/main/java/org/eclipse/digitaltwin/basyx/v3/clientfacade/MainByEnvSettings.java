package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.Aas4jObjectMapperFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.CaffeineBasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints.EndpointResolvers;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.SubmodelElementPathsIterable;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.SortDirection;

import com.fasterxml.jackson.core.JsonProcessingException;

public class MainByEnvSettings {

	public static void main(String[] args) throws JsonProcessingException {
		BasyxServiceFacade facade = new DefaultBasyxServiceFacade().withEndpointResolver(EndpointResolvers.firstWithAddress("127.0.0.1:8081")).withClientCache(new CaffeineBasyxClientCache());

		AssetAdministrationShell shell = facade.getShellById("http://aas.twinficient.de/virtual-factory-hall/BWS/Halle_A");

		for (Submodel eachSm : facade.getAllSubmodels(shell)) {
			String value = new Aas4jObjectMapperFactory().newObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(eachSm);
			System.out.println(value);
			for (String eachPath : new SubmodelElementPathsIterable(eachSm)) {
				System.out.println(eachPath);
			}
			System.out.println(new SubmodelElementPathsIterable(eachSm).stream().count());

			System.out.println(facade.getAllSubmodelElementPaths(eachSm).stream().count());
			facade.getSubmodelElementByIdShort(eachSm, "HeatingZones.HeatingZonesC9.HeatingZoneC9Hz3.HeatingZoneToHeatersC9Hz3.HeatingZoneToHeatersRelationShipElementC93Heater9").map(SubmodelElement::getIdShort)
					.ifPresent(System.err::println);
		}
		facade.getAllSubmodels(shell).stream().map(Submodel::getKind).forEach(System.err::println);

		shell = facade.getShellById("http://aas.twinficient.de/heater/BWS/C1/1/1");
		System.out.println(shell.getId());
		facade.findShellsByIdShortRegex("^Heater: BWS-C1-1-1.*$").stream().map(AssetAdministrationShell::getId).forEach(System.out::println);
//		runGetAll(facade);
//		runGetById(facade);
//		runGetByIdShort(facade);

	}

	private static void runGetByIdShort(DefaultBasyxServiceFacade facade) {
		for (AssetAdministrationShell eachShell : facade.findShellsByIdShortRegex("^Heater: Salmet-C.*-.*-.*$", SortDirection.ASC)) {
			System.out.println(eachShell.getIdShort());
		}

	}

	private static void runGetById(DefaultBasyxServiceFacade facade) {
		AssetAdministrationShell shell = facade.getShellById("http://aas.twinficient.de/heater/BWS/C1/1/1");
		System.out.println(shell.getId());
		Submodel sm = facade.getSubmodelById("http://sm.twinficient.de/topology/heater/BWS/C1/1/1");
		System.out.println(sm.getId());
	}

	private static void runGetAll(DefaultBasyxServiceFacade facade) {
		for (AssetAdministrationShell eachShell : facade.getAllShells()) {
			System.out.println(eachShell.getId());
			System.out.println(eachShell.getIdShort());
			for (Submodel eachSm : facade.getAllSubmodels(eachShell)) {
				System.out.println(eachSm.getId());
			}
		}
		for (Submodel eachSm : facade.getAllSubmodels()) {
			System.out.println(eachSm.getId());
		}
	}
}

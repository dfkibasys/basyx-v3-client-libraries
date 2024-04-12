package org.eclipse.gigitaltwin.basyx.v3.clientfacade;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.SortDirection;
import org.eclipse.gigitaltwin.basyx.v3.clientfacade.cache.CaffeineBasyxClientCache;
import org.eclipse.gigitaltwin.basyx.v3.clientfacade.endpoints.EndpointResolvers;

public class MainByEnvSettings {

	public static void main(String[] args) {
		BasyxServiceFacade facade = new BasyxServiceFacade()
				.withEndpointResolver(EndpointResolvers.firstWithAddress("127.0.0.1:8081"))
				.withClientCache(new CaffeineBasyxClientCache());

		AssetAdministrationShell shell = facade.getShellById("http://aas.twinficient.de/heater/BWS/C1/1/1");
		System.out.println(shell.getId());
		
		facade.getAllSubmodels(shell).stream().map(Submodel::getKind).forEach(System.err::println);
		
		shell = facade.getShellById("http://aas.twinficient.de/heater/BWS/C1/1/1");
		System.out.println(shell.getId());
		facade.findShellsByIdShortRegex("^Heater: BWS-C1-1-1.*$").stream().map(AssetAdministrationShell::getId).forEach(System.out::println);
//		runGetAll(facade);
//		runGetById(facade);
//		runGetByIdShort(facade);
	}

	private static void runGetByIdShort(BasyxServiceFacade facade) {
		for (AssetAdministrationShell eachShell : facade.findShellsByIdShortRegex("^Heater: Salmet-C.*-.*-.*$", SortDirection.ASC)) {
			System.out.println(eachShell.getIdShort());
		}
		
	}

	private static void runGetById(BasyxServiceFacade facade) {
		AssetAdministrationShell shell = facade.getShellById("http://aas.twinficient.de/heater/BWS/C1/1/1");
		System.out.println(shell.getId());
		Submodel sm = facade.getSubmodelById("http://sm.twinficient.de/topology/heater/BWS/C1/1/1");
		System.out.println(sm.getId());
	}

	private static void runGetAll(BasyxServiceFacade facade) {
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

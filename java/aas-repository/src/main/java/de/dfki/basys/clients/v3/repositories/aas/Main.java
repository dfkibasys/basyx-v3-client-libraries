package de.dfki.basys.clients.v3.repositories.aas;

import de.dfki.basys.clients.v3.ApiException;
import de.dfki.basys.clients.v3.metamodel.part1.AssetAdministrationShell;
import de.dfki.basys.clients.v3.repositories.aas.api.AssetAdministrationShellRepositoryApi;

public class Main {

	public static void main(String[] args) throws ApiException {
		AssetAdministrationShellRepositoryApi api = new AssetAdministrationShellRepositoryApi("http://localhost:8081");
		System.out.println(api.getDescription());

		AssetAdministrationShell shell = api.getAssetAdministrationShellById("https://acplt.test/Test_AssetAdministrationShell");
		System.out.println(shell);
	}

}

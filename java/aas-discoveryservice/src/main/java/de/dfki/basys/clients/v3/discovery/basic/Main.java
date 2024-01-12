package de.dfki.basys.clients.v3.discovery.basic;

import de.dfki.basys.clients.v3.ApiException;
import de.dfki.basys.clients.v3.discovery.basic.api.AssetAdministrationShellBasicDiscoveryApi;

public class Main {
	
	
	public static void main(String[] args) throws ApiException {
		AssetAdministrationShellBasicDiscoveryApi api = new AssetAdministrationShellBasicDiscoveryApi("http://localhost:8081");	
		System.out.println(api.getDescription());
		System.out.println(api.getAllAssetLinksById("https://acplt.test/Test_AssetAdministrationShell"));
	}
}

package de.dfki.basys.clients.v3.registries.submodel;

import de.dfki.basys.clients.v3.ApiException;
import de.dfki.basys.clients.v3.metamodel.part2.GetSubmodelDescriptorsResult;
import de.dfki.basys.clients.v3.registries.submodel.api.SubmodelRegistryApi;

public class Main {

	public static void main(String[] args) throws ApiException {
		SubmodelRegistryApi api = new SubmodelRegistryApi("http://localhost:8082/api/v3.0");
		GetSubmodelDescriptorsResult result = api.getAllSubmodelDescriptors(null, null);
		System.out.println(result);
		
		System.out.println(api.getSubmodelDescriptorById("http://acplt.test/Submodels/Assets/TestAsset/Identification"));

	}

}

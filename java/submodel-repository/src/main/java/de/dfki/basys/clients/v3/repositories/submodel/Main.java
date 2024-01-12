package de.dfki.basys.clients.v3.repositories.submodel;

import de.dfki.basys.clients.v3.ApiException;
import de.dfki.basys.clients.v3.ApiResponse;
import de.dfki.basys.clients.v3.metamodel.part2.GetSubmodelElementsResult;
import de.dfki.basys.clients.v3.repositories.submodel.api.SubmodelRepositoryApi;

public class Main {

	public static void main(String[] args) throws ApiException {
		SubmodelRepositoryApi api = new SubmodelRepositoryApi("http://localhost:8081");
		System.out.println(api.getAllSubmodels(null, null, null, null, null, null));
		System.out.println(api.getAllSubmodelElements("http://acplt.test/Submodels/Assets/TestAsset/Identification", 1, null, null, null));
	}

}

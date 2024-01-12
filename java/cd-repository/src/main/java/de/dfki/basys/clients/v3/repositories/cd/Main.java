package de.dfki.basys.clients.v3.repositories.cd;

import de.dfki.basys.clients.v3.ApiException;
import de.dfki.basys.clients.v3.metamodel.part2.GetConceptDescriptionsResult;
import de.dfki.basys.clients.v3.repositories.cd.api.ConceptDescriptionRepositoryApi;

public class Main {

	public static void main(String[] args) throws ApiException {
		ConceptDescriptionRepositoryApi api = new ConceptDescriptionRepositoryApi("http://localhost:8081");
		System.out.println(api.getDescription());
		GetConceptDescriptionsResult result = api.getAllConceptDescriptions(null, null, null, null, null);
		System.out.println(result);
	}

}

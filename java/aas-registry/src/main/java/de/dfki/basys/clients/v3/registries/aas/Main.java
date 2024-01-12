package de.dfki.basys.clients.v3.registries.aas;

import java.util.List;

import de.dfki.basys.clients.v3.ApiException;
import de.dfki.basys.clients.v3.metamodel.part1.AdministrativeInformation;
import de.dfki.basys.clients.v3.metamodel.part2.Endpoint;
import de.dfki.basys.clients.v3.metamodel.part2.GetAssetAdministrationShellDescriptorsResult;
import de.dfki.basys.clients.v3.metamodel.part2.ProtocolInformation;
import de.dfki.basys.clients.v3.metamodel.part2.SubmodelDescriptor;
import de.dfki.basys.clients.v3.registries.aas.api.AssetAdministrationShellRegistryApi;

public class Main {

	private static final String SM_ID = "http://test.de";
	private static final String AAS_ID = "https://acplt.test/Test_AssetAdministrationShell";

	public static void main(String[] args) throws ApiException {
		AssetAdministrationShellRegistryApi api = new AssetAdministrationShellRegistryApi("http://localhost:8083/api/v3.0");
		GetAssetAdministrationShellDescriptorsResult result = api.getAllAssetAdministrationShellDescriptors(null, null, null, null);
		System.out.println(result.getPagingMetadata().getCursor());
		System.out.println(result.getResult());
		System.out.println(api.getAssetAdministrationShellDescriptorById(AAS_ID).getId());

		SubmodelDescriptor descriptor = new SubmodelDescriptor();
		descriptor.setId(SM_ID);
		descriptor.setIdShort("tt");
		descriptor.administration(new AdministrativeInformation().version("1"));
		descriptor.endpoints(List.of(new Endpoint()._interface("http").protocolInformation(new ProtocolInformation().href("http://www.web.test"))));
		System.out.println(api.postSubmodelDescriptorThroughSuperpath(AAS_ID, descriptor));
		System.out.println(api.getSubmodelDescriptorByIdThroughSuperpath(AAS_ID, SM_ID));
	}
}

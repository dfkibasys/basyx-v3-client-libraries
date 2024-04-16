package org.eclipse.digitaltwin.basyx.v3.clientfacade.api;

import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxRegistryServiceConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BasyxRegistryApis {

	private final AssetAdministrationShellRegistryApi shellRegistryApi;
	private final SubmodelRegistryApi submodelRegistryApi;

	private BasyxRegistryApis(AssetAdministrationShellRegistryApi shellRegistryApi, SubmodelRegistryApi submodelRegistryApi) {
		this.shellRegistryApi = shellRegistryApi;
		this.submodelRegistryApi = submodelRegistryApi;
	}
	
	public BasyxRegistryApis(ObjectMapper mapper, BasyxRegistryServiceConfiguration conf) {
		this(mapper, conf.getAasRegistryUrl(), conf.getSubmodelRegistrUrl());
	}
	
	private BasyxRegistryApis(ObjectMapper mapper, String aasRegistryUrl, String submodelRegistryUrl) {
		this(new AssetAdministrationShellRegistryApi(mapper, aasRegistryUrl), new SubmodelRegistryApi(mapper, submodelRegistryUrl));
	}
	
	public AssetAdministrationShellRegistryApi getShellRegistryApi() {
		return shellRegistryApi;
	}
	
	public SubmodelRegistryApi getSubmodelRegistryApi() {
		return submodelRegistryApi;
	}

	
}

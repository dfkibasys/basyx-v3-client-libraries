package org.eclipse.gigitaltwin.basyx.v3.clientfacade.config;

public class EnvironmentBasedBasyxServiceConfiguration implements BasyxServiceConfiguration {

	private static final String ENV_BASYX_AASREGISTRY_URL = "BASYX_AASREGISTRY_URL";
	private static final String ENV_BASYX_SUBMODELREGISTRY_URL = "BASYX_SUBMODELREGISTRY_URL";
	private static final String ENV_BASYX_FETCH_LIMIT = "BASYX_FETCH_LIMIT";
	
	@Override
	public String getAasRegistryUrl() {
		return System.getenv(ENV_BASYX_AASREGISTRY_URL);
	}

	@Override
	public String getSubmodelRegistrUrl() {
		return System.getenv(ENV_BASYX_SUBMODELREGISTRY_URL);
	}

	@Override
	public Integer getFetchLimit() {
		String fetchLimitAsString = System.getenv(ENV_BASYX_FETCH_LIMIT);
		if (fetchLimitAsString == null) {
			return DEFAULT_FETCH_LIMIT;
		}
		return Integer.parseInt(fetchLimitAsString);
	}

}

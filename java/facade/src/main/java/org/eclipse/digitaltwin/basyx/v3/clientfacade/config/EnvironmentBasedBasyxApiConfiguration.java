package org.eclipse.digitaltwin.basyx.v3.clientfacade.config;

import org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.config.AutoRegistrationConfig;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.config.EnvironmentBasedAutoRegistrationConfig;

public class EnvironmentBasedBasyxApiConfiguration implements BasyxApiConfiguration {
    private static final String ENV_BASYX_FETCH_LIMIT = "BASYX_CLIENT_FETCH_LIMIT";
    private static final String ENV_BASYX_AASREGISTRY_URL = "BASYX_CLIENT_AASREGISTRY";
    private static final String ENV_BASYX_SUBMODELREGISTRY_URL = "BASYX_CLIENT_SUBMODELREGISTRY";
    private static final String ENV_AASREPOSITORY_URL = "BASYX_CLIENT_AASREPOSITORY";
    private static final String ENV_SUBMODELREPOSITORY_URL = "BASYX_CLIENT_SUBMODELREPOSITORY";
    private static final String ENV_BASYX_AASXFILESERVER_URL = "BASYX_CLIENT_AASXFILESERVER";

    @Override
    public Integer getFetchLimit() {
        return EnvironmentVars.getIntOrDefault(ENV_BASYX_FETCH_LIMIT, DEFAULT_FETCH_LIMIT);
    }

    @Override
    public String getAasRegistryUrl() {
        return EnvironmentVars.getOrThrow(ENV_BASYX_AASREGISTRY_URL);
    }

    @Override
    public String getSubmodelRegistrUrl() {
        return EnvironmentVars.getOrThrow(ENV_BASYX_SUBMODELREGISTRY_URL);
    }

    @Override
    public String getAasRepositoryUrl() {
        return EnvironmentVars.getOrThrow(ENV_AASREPOSITORY_URL);
    }

    @Override
    public String getSubmodelRepositoryUrl() {
        return EnvironmentVars.getOrThrow(ENV_SUBMODELREPOSITORY_URL);
    }

    @Override
    public AutoRegistrationConfig getAutoRegistrationConfig() {
        return new EnvironmentBasedAutoRegistrationConfig();
    }

    @Override
    public String getAasxFileServerUrl() {
        return EnvironmentVars.getOrThrow(ENV_BASYX_AASXFILESERVER_URL);
    }
}

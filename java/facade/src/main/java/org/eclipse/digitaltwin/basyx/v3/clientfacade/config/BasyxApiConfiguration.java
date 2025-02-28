package org.eclipse.digitaltwin.basyx.v3.clientfacade.config;

import org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.config.AutoRegistrationConfig;

public interface BasyxApiConfiguration {
    Integer DEFAULT_FETCH_LIMIT = 100;

    Integer getFetchLimit();

    String getAasRegistryUrl();

    String getSubmodelRegistrUrl();

    String getAasRepositoryUrl();

    String getSubmodelRepositoryUrl();

    AutoRegistrationConfig getAutoRegistrationConfig();

    String getAasxFileServerUrl();
}

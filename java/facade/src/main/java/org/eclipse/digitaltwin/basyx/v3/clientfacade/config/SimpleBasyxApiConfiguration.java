package org.eclipse.digitaltwin.basyx.v3.clientfacade.config;

import org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.config.AutoRegistrationConfig;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.config.SimpleAutoRegistrationConfig;

public class SimpleBasyxApiConfiguration implements BasyxApiConfiguration {
    private Integer fetchLimit;
    private String aasRegistryUrl;
    private String submodelRegistryUrl;
    private String aasRepoUrl;
    private String submodelRepoUrl;
    private String aasxFileServerUrl;

    @Override
    public Integer getFetchLimit() {
        return fetchLimit == null ? DEFAULT_FETCH_LIMIT : fetchLimit;
    }

    @Override
    public String getAasRegistryUrl() {
        return aasRegistryUrl;
    }

    @Override
    public String getSubmodelRegistrUrl() {
        return submodelRegistryUrl;
    }

    @Override
    public String getAasRepositoryUrl() {
        return aasRepoUrl;
    }

    @Override
    public String getSubmodelRepositoryUrl() {
        return submodelRepoUrl;
    }

    @Override
    public AutoRegistrationConfig getAutoRegistrationConfig() {
        return new SimpleAutoRegistrationConfig();
    }

    @Override
    public String getAasxFileServerUrl() {
        return aasxFileServerUrl;
    }

    public SimpleBasyxApiConfiguration withFetchLimit(int fetchLimit) {
        this.fetchLimit = fetchLimit;
        return this;
    }
    public SimpleBasyxApiConfiguration withAasRegistryUrl(String aasRegistryUrl) {
        this.aasRegistryUrl = aasRegistryUrl;
        return this;
    }

    public SimpleBasyxApiConfiguration withSubmodelRegistryUrl(String submodelRegistryUrl) {
        this.submodelRegistryUrl = submodelRegistryUrl;
        return this;
    }

    public SimpleBasyxApiConfiguration withAasRepositoryUrl(String url) {
        this.aasRepoUrl = url;
        return this;
    }

    public SimpleBasyxApiConfiguration withSubmodelRepositoryUrl(String url) {
        this.submodelRepoUrl = url;
        return this;
    }

    public final SimpleBasyxApiConfiguration withEnvironmentUrl(String url) {
        this.aasRepoUrl = url;
        this.submodelRepoUrl = url;
        return this;
    }

    public SimpleBasyxApiConfiguration withAasxFileServerUrl(String aasxFileServerUrl) {
        this.aasxFileServerUrl = aasxFileServerUrl;
        return this;
    }

}

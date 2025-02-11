package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.BasyxApiFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.DefaultBasyxApiFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxApiConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.intercept.BasyxTransferInterceptor;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.*;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.config.EnvironmentBasedAuthorizerConfigProvider;
import org.eclipse.digitaltwin.basyx.v3.clients.JSON;
import org.eclipse.digitaltwin.basyx.v3.clients.api.*;

import java.util.Map;

public class DefaultBasyxApiManager implements BasyxApiManager {

    private final BasyxApiConfiguration config;
    private final ObjectMapper mapper;
    private final BasyxApiFactory apiFactory;

    public DefaultBasyxApiManager(BasyxApiConfiguration config) {
        this.config = config;
        this.mapper = JSON.getDefault().getMapper();
        this.apiFactory = new DefaultBasyxApiFactory(defaultInterceptor());
    }

    public DefaultBasyxApiManager(BasyxApiConfiguration config, ObjectMapper mapper, BasyxApiFactory factory) {
        this.config = config;
        this.mapper = mapper;
        this.apiFactory = factory;
    }

    protected static BasyxTransferInterceptor defaultInterceptor() {
        Map<String, BasyxAuthorizerConfigurationFactory> configFactories = defaultConfigFactories();
        EnvironmentBasedAuthorizerConfigProvider configProvider = new EnvironmentBasedAuthorizerConfigProvider(configFactories);
        MultiTokenBasyxAuthorizer authorizer = new MultiTokenBasyxAuthorizer(configProvider, new DefaultBasyxAuthorizerFactory());
        return new DefaultBasyxAuthorizationInterceptor(authorizer);
    }

    protected static Map<String, BasyxAuthorizerConfigurationFactory> defaultConfigFactories() {
        return Map.of(ServiceAccountAuthorizer.TYPE, new ServiceAccountAuthorizerConfigurationFactory()
                , NullBasyxAuthorizer.TYPE, new NullBasyxAuthorizerConfigurationFactory());
    }

    public BasyxApiConfiguration getConfig() {
        return config;
    }

    @Override
    public ObjectMapper getMapper() {
        return mapper;
    }

    public BasyxApiFactory getApiFactory() {
        return apiFactory;
    }

    @Override
    public AssetAdministrationShellRegistryApi getShellRegistryApi() {
        return apiFactory.newShellRegistryApi(mapper, config.getAasRegistryUrl());
    }

    @Override
    public AssetAdministrationShellRegistryApi getShellRegistryApi(String baseUrl) {
        return apiFactory.newShellRegistryApi(mapper, baseUrl);
    }

    @Override
    public SubmodelRegistryApi getSubmodelRegistryApi() {
        return apiFactory.newSubmodelRegistryApi(mapper, config.getSubmodelRegistrUrl());
    }

    @Override
    public SubmodelRegistryApi getSubmodelRegistryApi(String baseUrl) {
        return apiFactory.newSubmodelRegistryApi(mapper, baseUrl);
    }

    @Override
    public AssetAdministrationShellRepositoryApi getShellRepositoryApi() {
        return apiFactory.newShellRepositoryApi(mapper, config.getAasRepositoryUrl());
    }

    @Override
    public AssetAdministrationShellRepositoryApi getShellRepositoryApi(String baseUrl) {
        return apiFactory.newShellRepositoryApi(mapper, baseUrl);
    }

    @Override
    public SubmodelRepositoryApi getSubmodelRepositoryApi() {
        return apiFactory.newSubmodelRepositoryApi(mapper, config.getSubmodelRepositoryUrl());
    }

    @Override
    public SubmodelRepositoryApi getSubmodelRepositoryApi(String baseUrl) {
        return apiFactory.newSubmodelRepositoryApi(mapper, baseUrl);
    }

    @Override
    public AasxFileServerApi getAasxFileServerApi() {
        return apiFactory.newAasxFileServerApi(mapper, config.getAasxFileServerUrl());
    }

    @Override
    public AasxFileServerApi getAasxFileServerApi(String baseUrl) {
        return apiFactory.newAasxFileServerApi(mapper, baseUrl);
    }
}

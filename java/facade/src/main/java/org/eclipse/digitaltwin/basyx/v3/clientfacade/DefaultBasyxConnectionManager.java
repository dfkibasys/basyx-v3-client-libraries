/*******************************************************************************
 * Copyright (C) 2024 DFKI GmbH (https://www.dfki.de/en/web)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * SPDX-License-Identifier: MIT
 ******************************************************************************/
package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import java.util.List;
import java.util.Map;

import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.Aas4jObjectMapperFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.BasyxApiFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.DefaultBasyxApiFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.BasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.CacheUpdateHandler;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.DefaultBasyxClientCacheFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.config.EnvironmentBasedBasyxCacheConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxRegistryServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxUpdateConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.EnvironmentBasedBasyxServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.EnvironmentBasedBasyxUpdateConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.intercept.BasyxTransferInterceptor;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.RegistratingUpdateListener;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.config.AutoRegistrationConfig;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.BasyxAuthorizerConfigurationFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.DefaultBasyxAuthorizationInterceptor;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.DefaultBasyxAuthorizerFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.MultiTokenBasyxAuthorizer;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.NullBasyxAuthorizer;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.NullBasyxAuthorizerConfigurationFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.ServiceAccountAuthorizer;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.ServiceAccountAuthorizerConfigurationFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.config.EnvironmentBasedAuthorizerConfigProvider;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRegistryApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DefaultBasyxConnectionManager implements BasyxConnectionManager {

	private final ObjectMapper mapper;
	private final BasyxApiFactory apiFactory;
	private BasyxClientCache cache;
	
	public DefaultBasyxConnectionManager() {
		this (defaultInterceptor());
	}

	public DefaultBasyxConnectionManager(BasyxTransferInterceptor interceptor) {
		this(new Aas4jObjectMapperFactory().newObjectMapper(), new DefaultBasyxApiFactory(interceptor));
	}
	
	public DefaultBasyxConnectionManager(ObjectMapper mapper, BasyxApiFactory factory) {
		this.mapper = mapper;
		this.cache = defaultClientCache();
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

	protected BasyxClientCache defaultClientCache() {
		EnvironmentBasedBasyxCacheConfiguration config = new EnvironmentBasedBasyxCacheConfiguration();
		return new DefaultBasyxClientCacheFactory().newCache(config);
	}
	
	@Override
	public BasyxConnectionManager withClientCache(BasyxClientCache cache) {
		this.cache = cache;
		return this;
	}
	
	@Override
	public BasyxServiceFacade newServiceFacade() {
		return new DefaultBasyxServiceFacade(mapper, apiFactory, new EnvironmentBasedBasyxServiceConfiguration()).withClientCache(cache);
	}
	
	@Override
	public BasyxServiceFacade newServiceFacade(BasyxRegistryServiceConfiguration conf) {
		return new DefaultBasyxServiceFacade(mapper, apiFactory, conf).withClientCache(cache);
	}
	

	@Override
	public BasyxUpdateFacade newUpdateFacade(BasyxUpdateConfiguration conf) {
		DefaultBasyxUpdateFacade facade = new DefaultBasyxUpdateFacade(mapper, apiFactory, conf);

		assignListener(facade, conf);
		return facade;
	}	
	
	protected void assignListener(DefaultBasyxUpdateFacade facade, BasyxUpdateConfiguration conf) {
		CacheUpdateHandler cacheUpdateHandler = new CacheUpdateHandler(()->cache);
		AutoRegistrationConfig autoRegConf = conf.getAutoRegistrationConfig();
		if (autoRegConf.isEnabled()) {			
			AssetAdministrationShellRegistryApi aasRegApi = apiFactory.newShellRegistryApi(mapper, conf.getAasRegistryUrl());
			SubmodelRegistryApi smRegApi = apiFactory.newSubmodelRegistryApi(mapper, conf.getSubmodelRegistrUrl());				
			List<String> shellRepoHrefs = autoRegConf.getAasHrefs();
			List<String> submodelRepoHrefs = autoRegConf.getSubmodelHrefs();
			RegistratingUpdateListener regListener = new RegistratingUpdateListener(aasRegApi, smRegApi, shellRepoHrefs, submodelRepoHrefs);
			facade.setListeners(cacheUpdateHandler, regListener);
		} else  {
			facade.setListener(cacheUpdateHandler);	
		}
	}

	@Override
	public BasyxUpdateFacade newUpdateFacade() {
		return newUpdateFacade(new EnvironmentBasedBasyxUpdateConfiguration());
	}
	
	
	@Override
	public String toJsonPretty(Object object) {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	
}
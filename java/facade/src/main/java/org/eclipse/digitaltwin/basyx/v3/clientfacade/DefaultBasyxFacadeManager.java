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

import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.BasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.CacheUpdateHandler;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.DefaultBasyxClientCacheFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.config.EnvironmentBasedBasyxCacheConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxApiConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.RegistratingUpdateListener;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.config.AutoRegistrationConfig;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRegistryApi;

import java.util.List;

public class DefaultBasyxFacadeManager implements BasyxFacadeManager {

	private final BasyxApiManager apiManager;
	private BasyxClientCache cache;

	public DefaultBasyxFacadeManager(BasyxApiConfiguration config) {
		this(new DefaultBasyxApiManager(config));
	}

	public DefaultBasyxFacadeManager(BasyxApiManager apiManager) {
		this.apiManager = apiManager;
		this.cache = defaultClientCache();
	}

	protected BasyxClientCache defaultClientCache() {
		EnvironmentBasedBasyxCacheConfiguration config = new EnvironmentBasedBasyxCacheConfiguration();
		return new DefaultBasyxClientCacheFactory().newCache(config);
	}

	@Override
	public BasyxFacadeManager withClientCache(BasyxClientCache cache) {
		this.cache = cache;
		return this;
	}

	@Override
	public BasyxReadFacade newReadFacade() {
		return new DefaultBasyxReadFacade(apiManager).withClientCache(cache);
	}

	@Override
	public AasxFileServerFacade newAasxFileServerFacade() {
		return new DefaultAasxFileServerFacade(apiManager);
	}

	@Override
	public BasyxWriteFacade newWriteFacade() {
		DefaultBasyxWriteFacade facade = new DefaultBasyxWriteFacade(apiManager);

		assignListener(facade, apiManager.getConfig());
		return facade;
	}

	protected void assignListener(DefaultBasyxWriteFacade facade, BasyxApiConfiguration conf) {
		CacheUpdateHandler cacheUpdateHandler = new CacheUpdateHandler(()->cache);
		AutoRegistrationConfig autoRegConf = conf.getAutoRegistrationConfig();
		if (autoRegConf.isEnabled()) {
			AssetAdministrationShellRegistryApi aasRegApi = apiManager.getShellRegistryApi();
			SubmodelRegistryApi smRegApi = apiManager.getSubmodelRegistryApi();
			List<String> shellRepoHrefs = autoRegConf.getAasHrefs();
			List<String> submodelRepoHrefs = autoRegConf.getSubmodelHrefs();
			RegistratingUpdateListener regListener = new RegistratingUpdateListener(aasRegApi, smRegApi, shellRepoHrefs, submodelRepoHrefs);
			facade.setListeners(cacheUpdateHandler, regListener);
		} else  {
			facade.setListener(cacheUpdateHandler);	
		}
	}

}
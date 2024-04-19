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

import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.Aas4jObjectMapperFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.BasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.PassThroughBasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxRegistryServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxUpdateConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.EnvironmentBasedBasyxServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.EnvironmentBasedBasyxUpdateConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DefaultBasyxConnectionManager implements BasyxConnectionManager {

	private final ObjectMapper mapper;
	private BasyxClientCache cache;
	
	public DefaultBasyxConnectionManager(ObjectMapper mapper) {
		this.mapper = mapper;
		this.cache = new PassThroughBasyxClientCache();
	}
	
	public DefaultBasyxConnectionManager() {
		this(new Aas4jObjectMapperFactory().newObjectMapper());
	}
	
	@Override
	public BasyxConnectionManager withClientCache(BasyxClientCache cache) {
		this.cache = cache;
		return this;
	}
	
	@Override
	public BasyxServiceFacade newServiceFacade() {
		return new DefaultBasyxServiceFacade(mapper, new EnvironmentBasedBasyxServiceConfiguration()).withClientCache(cache);
	}
	
	@Override
	public BasyxServiceFacade newServiceFacade(BasyxRegistryServiceConfiguration conf) {
		return new DefaultBasyxServiceFacade(mapper, conf).withClientCache(cache);
	}
	
	@Override
	public BasyxUpdateFacade newUpdateFacade() {
		return new DefaultBasyxUpdateFacade(mapper, new EnvironmentBasedBasyxUpdateConfiguration()).withClientCache(cache);
	}
	
	@Override
	public BasyxUpdateFacade newUpdateFacade(BasyxUpdateConfiguration conf) {
		return new DefaultBasyxUpdateFacade(mapper, conf).withClientCache(cache);
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
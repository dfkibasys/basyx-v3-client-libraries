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
package org.eclipse.digitaltwin.basyx.v3.clientfacade.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.config.BasyxAuthorizerConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.config.ConfigurationProvider;

public class MultiTokenBasyxAuthorizer implements BasyxAuthorizer {

	private final ConfigurationProvider provider;
	
	private final Map<BasyxAuthorizerConfiguration, BasyxAuthorizer> authorizers = new HashMap<>();
	private final BasyxAuthorizerFactory authorizerFactory;
	
	public MultiTokenBasyxAuthorizer(ConfigurationProvider configurationProvider, BasyxAuthorizerFactory authorizerFactory) {
		this.provider = configurationProvider;
		this.authorizerFactory = authorizerFactory;
	}

	@Override
	public void applyAuthorization(String baseUri, java.net.http.HttpRequest.Builder builder) {
		Optional<BasyxAuthorizerConfiguration> configOpt = provider.getAuthorizerConfiguration(baseUri);
		if (configOpt.isPresent()) {
			BasyxAuthorizerConfiguration config = configOpt.get();
			BasyxAuthorizer authorizer = authorizers.computeIfAbsent(config, authorizerFactory::newAuthorizer);
			authorizer.applyAuthorization(baseUri, builder);
		}
	}
	
}

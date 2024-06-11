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

import java.util.Optional;

import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.config.BasyxAuthorizerConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.config.DefaultClientCredentialsAuthorizerConfiguration;

import com.google.common.base.Function;


public class ServiceAccountAuthorizerConfigurationFactory implements BasyxAuthorizerConfigurationFactory {

	private static final String CLIENT_SECRET = "CLIENT_SECRET";
	private static final String CLIENT_ID = "CLIENT_ID";
	private static final String REALM = "REALM";
	private static final String ISSUER_URL = "ISSUER_URL";
	
	@Override
	public BasyxAuthorizerConfiguration newAuthorizerConfiguration(Function<String, Optional<String>> configurationParams) {
		DefaultClientCredentialsAuthorizerConfiguration config = new DefaultClientCredentialsAuthorizerConfiguration();
		configurationParams.apply(CLIENT_ID).ifPresent(config::withClientId);
		configurationParams.apply(CLIENT_SECRET).ifPresent(config::withClientSecret);
		configurationParams.apply(REALM).ifPresent(config::withRealm);
		configurationParams.apply(ISSUER_URL).ifPresent(config::withIssuerUrl);
		return config;
	}
	
}
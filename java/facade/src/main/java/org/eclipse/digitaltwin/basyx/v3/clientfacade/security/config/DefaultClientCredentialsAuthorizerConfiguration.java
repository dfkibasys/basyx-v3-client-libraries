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
package org.eclipse.digitaltwin.basyx.v3.clientfacade.security.config;

public class DefaultClientCredentialsAuthorizerConfiguration implements ClientCredentialsAuthorizerConfiguration {

	private String issuerUrl;
	private String realm;
	private String clientId;
	private String clientSecret;
	
	public DefaultClientCredentialsAuthorizerConfiguration withIssuerUrl(String issuerUrl) {
		this.issuerUrl = issuerUrl;
		return this;
	}
	
	@Override
	public String getIssuerUrl() {
		return issuerUrl;
	}

	@Override
	public String getRealm() {
		return realm;
	}
	
	public DefaultClientCredentialsAuthorizerConfiguration withRealm(String realm) {
		this.realm = realm;
		return this;
	}
	

	@Override
	public String getClientId() {
		return clientId;
	}
	
	public DefaultClientCredentialsAuthorizerConfiguration withClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

	@Override
	public String getClientSecret() {
		return clientSecret;
	}

	public DefaultClientCredentialsAuthorizerConfiguration withClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
		return this;
	}
	
	@Override
	public void assertValid() throws AuthorizerConfigurationInvalidException {
		if (this.clientId == null) {
			throw new AuthorizerConfigurationInvalidException("'client-id' not provided for service-account authorizer.");
		}
		if (this.clientSecret == null) {
			throw new AuthorizerConfigurationInvalidException("'client-secret' not provided for service-account authorizer.");
		}
		if (this.issuerUrl == null) {
			throw new AuthorizerConfigurationInvalidException("'issuer-url' not provided for service-account authorizer.");
		}
		if (this.realm == null) {
			throw new AuthorizerConfigurationInvalidException("'realm' not provided for service-account authorizer.");
		}
	}
	
}
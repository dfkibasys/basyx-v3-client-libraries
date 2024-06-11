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

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.config.ClientCredentialsAuthorizerConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class ServiceAccountAuthorizer implements BasyxAuthorizer {

	private static final long LATENCY_BUFFER_SECS = 5;

	public static final String TYPE = "service-account";
	
	private final ClientCredentialsAuthorizerConfiguration config;
	
	private JwtTokenInfo currentToken;
	
	public ServiceAccountAuthorizer(ClientCredentialsAuthorizerConfiguration config) {
		this.config = config;
	}	

	@Override
	public void applyAuthorization(String baseUri, Builder builder) {
		if (needsNewToken()) {
			pullToken();
		}
		builder.header("Authorization", "Bearer " + currentToken.getToken());
	}

	private boolean needsNewToken() {
		if (currentToken == null) {
			return true;
		}
		Instant timeToRefresh = currentToken.expiresAt().minusSeconds(LATENCY_BUFFER_SECS);
		return timeToRefresh.isBefore(Instant.now());
	}

	private void pullToken() {
		try {
			currentToken = getToken(config.getClientId(), config.getClientSecret());
		} catch (InterruptedException | IOException ex) {
			throw new ApiException(ex);
		}
	}
	
	public JwtTokenInfo getToken(String clientId, String secret) throws IOException, InterruptedException {
		String url = createIssuerRealmTokenUrl();

		HttpRequest authRequest = createAuthorizationRequest(url, clientId, secret);

		HttpClient client = HttpClient.newHttpClient();
		Instant now = Instant.now();
		HttpResponse<?> response = client.send(authRequest, HttpResponse.BodyHandlers.ofString());
		
		return createJwtTokenInfo(now, response);
	}
	
	private JwtTokenInfo createJwtTokenInfo(Instant requestTime, HttpResponse<?> response) throws IOException {
		TreeNode tree = new ObjectMapper().createParser(response.body().toString()).readValueAsTree();
		TextNode accessTokenNode = (TextNode) tree.get("access_token");
		IntNode expiresInNode = (IntNode) tree.get("expires_in");
		long expiresInSeconds = expiresInNode.longValue();
		
		String token = accessTokenNode.asText();
		Instant expiresAt = requestTime.plusSeconds(expiresInSeconds);
		
		return new DefaultJwtTokenInfo(token, expiresAt);
	}

	private String createIssuerRealmTokenUrl() {
		 return config.getIssuerUrl() + "/realms/" + config.getRealm() + "/protocol/openid-connect/token";
	}

	private HttpRequest createAuthorizationRequest(String url, String clientId, String secret) {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("grant_type", "client_credentials");
		parameters.put("client_id", clientId);
		parameters.put("client_secret", secret);

		String form = parameters.entrySet()
		    .stream()
		    .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
		    .collect(Collectors.joining("&"));

		return HttpRequest.newBuilder()
		    .uri(URI.create(url))
		    .header("Content-Type", "application/x-www-form-urlencoded")
		    .POST(HttpRequest.BodyPublishers.ofString(form))
		    .build();
	}

	public static class DefaultJwtTokenInfo implements JwtTokenInfo {
		private final String token;
		private final Instant expiresAt;
		
		public DefaultJwtTokenInfo(String token, Instant expiresAt) {
			this.token = token;
			this.expiresAt = expiresAt;
		}		
		
		@Override
		public String getToken() {
			return token;
		}
		
		@Override
		public Instant expiresAt() {
			return expiresAt; 
		}
	}

}
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.digitaltwin.basyx.v3.clientfacade.security.BasyxAuthorizerConfigurationFactory;

import com.google.common.base.Function;

public class EnvironmentBasedAuthorizerConfigProvider implements ConfigurationProvider {

	private static final String DEFAULT_IDENTIFIER = "DEFAULT";

	private static final String BASE_URLS = "BASE_URLS";

	private static final String AUTHORIZER_PREFIX = "BASYX_CLIENT_AUTH_";

	private static final String TYPE = "TYPE";

	private final Optional<BasyxAuthorizerConfiguration> defaultConfigurationOpt;
	private final Map<String, BasyxAuthorizerConfiguration> uriBasedConfigurations;

	public EnvironmentBasedAuthorizerConfigProvider(Map<String, BasyxAuthorizerConfigurationFactory> factories) {
		Map<String, Map<String, String>> defs = System.getenv().entrySet().stream().filter(this::filterEntries).collect(Collectors.toMap(this::getIdentifier, this::extractValue, this::mergeMaps));	
		Map<String, String> defaultValues = Optional.ofNullable(defs.remove(DEFAULT_IDENTIFIER)).orElse(Map.of());		
		defaultConfigurationOpt = initializeDefaultConf(defaultValues, factories);
		uriBasedConfigurations = initializeSpeficConfs(defs, defaultValues, factories);
	}
	
	private Map<String, String> mergeMaps(Map<String, String> first, Map<String, String> second) {
		first.putAll(second);
		return first;
	}

	private Map<String, BasyxAuthorizerConfiguration> initializeSpeficConfs(Map<String, Map<String, String>> defs, Map<String, String> defaultValues, Map<String, BasyxAuthorizerConfigurationFactory> factories) {		
		Map<String, BasyxAuthorizerConfiguration> result = new HashMap<>();		
		for (Entry<String, Map<String,String>> eachDef : defs.entrySet()) {
			String key = eachDef.getKey();
			Map<String, String> values = eachDef.getValue();
			Function<String, Optional<String>> confProvider = s -> getOrDefault(s, values, defaultValues);
			String urls =  values.get(BASE_URLS);
			String type = confProvider.apply(TYPE).orElseThrow(()->new AuthorizerConfigurationException("No type specified for autorizer configuration could not be created for setting '" + key + '.'));
			BasyxAuthorizerConfigurationFactory factory = factories.get(type);
			if (factory == null) {
				throw new AuthorizerConfigurationException("Autorizer configuration could not be created for setting '" + key + '.');
			}
			BasyxAuthorizerConfiguration conf = factory.newAuthorizerConfiguration(confProvider);
			conf.assertValid();
			Arrays.stream(urls.split(",")).filter(Predicate.not(String::isBlank)).forEach((url)->result.put(url, conf));
		}
		return result;
	}

	private Optional<BasyxAuthorizerConfiguration> initializeDefaultConf(Map<String, String> defaultValues, Map<String, BasyxAuthorizerConfigurationFactory> factories) {		
		String type = defaultValues.get(TYPE);
		if (type == null) {
			return Optional.empty();
		}
		BasyxAuthorizerConfigurationFactory factory = factories.get(type);
		if (factory == null) {
			throw new AuthorizerConfigurationException("Autorizer configuration could not be created for the 'default' setting.");
		}
		BasyxAuthorizerConfiguration conf = factory.newAuthorizerConfiguration(k -> Optional.ofNullable(defaultValues.get(k)));
		conf.assertValid();
		return Optional.of(conf);
	}

	@Override
	public Optional<BasyxAuthorizerConfiguration> getAuthorizerConfiguration(String baseUrl) {
		return Optional.ofNullable(uriBasedConfigurations.getOrDefault(baseUrl, defaultConfigurationOpt.orElse(null)));
	}

	private Optional<String> getOrDefault(String key, Map<String, String> values, Map<String, String> defaults) {
		String value = values.get(key);
		if (value != null) {
			return Optional.of(value);
		}
		return Optional.ofNullable(defaults.get(key));
	}

	private Map<String, String> extractValue(Entry<String, String> entry) {
		String key = entry.getKey();
		String identifier = getIdentifier(key);
		int suffixPos = AUTHORIZER_PREFIX.length() + identifier.length() + 1;
		String suffix = key.substring(suffixPos);
		HashMap<String, String> toReturn = new HashMap<>();
		toReturn.put(suffix, entry.getValue());
		return toReturn;
	}
	private String getIdentifier(Entry<String, String> entry) {
		return getIdentifier(entry.getKey());
	}

	private String getIdentifier(String key) {
		String[] segments = key.split("_");
		if (segments.length <= 3) {
			throw new NoAuthorizerIdentifier(key);
		}
		return segments[3];
	}

	private boolean filterEntries(Entry<String, String> entries) {
		return entries.getKey().startsWith(AUTHORIZER_PREFIX);
	}

	private static class NoAuthorizerIdentifier extends IllegalArgumentException {

		private static final long serialVersionUID = 1L;

		public NoAuthorizerIdentifier(String key) {
			super("No Authorizer Identifier set in env key '" + key + "'.");
		}
	}

	private static class AuthorizerConfigurationException extends IllegalArgumentException {

		private static final long serialVersionUID = 1L;

		public AuthorizerConfigurationException(String msg) {
			super(msg);
		}
	}
}
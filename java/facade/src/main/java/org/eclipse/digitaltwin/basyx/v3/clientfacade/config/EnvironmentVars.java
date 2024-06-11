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
package org.eclipse.digitaltwin.basyx.v3.clientfacade.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class EnvironmentVars {

	private EnvironmentVars() {	
	}
	
	public static List<String> getConfigList(String envName) {
		String value = getOrDefault(envName, "");
		return Arrays.stream(value.split(",")).filter(Predicate.not(String::isBlank)).collect(Collectors.toUnmodifiableList());
	}
	
	public static Map<String, String> getConfigMap(String envMapPrefix) {
		return getConfigMap(envMapPrefix, Function.identity());
	}
	
	public static <T> Map<String, T> getConfigMap(String envMapPrefix, Function<String, T> mapper) {
		Map<String, T> result = new HashMap<>();
		for (Entry<String, String> eachEntry : System.getenv().entrySet()) {
			String key = eachEntry.getKey();
			if (key.startsWith(envMapPrefix)) {
				String newKey = key.substring(envMapPrefix.length()+1);
				result.put(newKey, mapper.apply(eachEntry.getValue()));
			}
		}
		return result;
	}
	
	public static boolean getBooleanOrDefault(String envName, boolean defaultValue) {
		String value = System.getenv(envName);
		if (value == null) {
			return defaultValue;
		}
		return Boolean.parseBoolean(value);
	}
	
	public static int getIntOrDefault(String envName, int defaultValue) {
		String value = System.getenv(envName);
		if (value == null) {
			return defaultValue;
		}
		return Integer.parseInt(value);
	}
	
	public static String getOrDefault(String envName, String defaultValue) {
		String value = System.getenv(envName);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}
	
	public static String getOrThrow(String envName) {
		String value = System.getenv(envName);
		if (value == null) {
			throw new EnvironmentVariableNotSetException(envName);
		}
		return value;
	}
	
	private static final class EnvironmentVariableNotSetException extends IllegalArgumentException {
		
		private static final long serialVersionUID = 1L;

		public EnvironmentVariableNotSetException(String envName) {
			super("Environment variable '" + envName + "' not set!");
		}	
	}	
}
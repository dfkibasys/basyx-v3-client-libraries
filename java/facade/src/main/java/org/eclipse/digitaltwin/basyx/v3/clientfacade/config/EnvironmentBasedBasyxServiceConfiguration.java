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

public class EnvironmentBasedBasyxServiceConfiguration implements BasyxRegistryServiceConfiguration {

	private static final String ENV_BASYX_AASREGISTRY_URL = "BASYX_AASREGISTRY";
	private static final String ENV_BASYX_SUBMODELREGISTRY_URL = "BASYX_SUBMODELREGISTRY";
	private static final String ENV_BASYX_FETCH_LIMIT = "BASYX_FETCH_LIMIT";
	
	@Override
	public String getAasRegistryUrl() {
		return System.getenv(ENV_BASYX_AASREGISTRY_URL);
	}

	@Override
	public String getSubmodelRegistrUrl() {
		return System.getenv(ENV_BASYX_SUBMODELREGISTRY_URL);
	}

	@Override
	public Integer getFetchLimit() {
		String fetchLimitAsString = System.getenv(ENV_BASYX_FETCH_LIMIT);
		if (fetchLimitAsString == null) {
			return DEFAULT_FETCH_LIMIT;
		}
		return Integer.parseInt(fetchLimitAsString);
	}

}

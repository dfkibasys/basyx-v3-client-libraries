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

public class SimpleBasyxServiceConfiguration implements BasyxRegistryServiceConfiguration {

	private String aasRegistryUrl;
	private String submodelRegistryUrl;
	private Integer fetchLimit;
	
	public SimpleBasyxServiceConfiguration withAasRegistryUrl(String aasRegistryUrl) {
		this.aasRegistryUrl = aasRegistryUrl;
		return this;
	}
	
	@Override
	public String getAasRegistryUrl() {
		return aasRegistryUrl;
	}
	
	public SimpleBasyxServiceConfiguration withSubmodelRegistryUrl(String submodelRegistryUrl) {
		this.submodelRegistryUrl = submodelRegistryUrl;
		return this;
	}
	
	@Override
	public String getSubmodelRegistrUrl() {
		return submodelRegistryUrl;
	}
	
	public SimpleBasyxServiceConfiguration withFetchLimit(int fetchLimit) {
		this.fetchLimit = fetchLimit;
		return this;
	}
	
	@Override
	public Integer getFetchLimit() {
		return fetchLimit;
	}
}

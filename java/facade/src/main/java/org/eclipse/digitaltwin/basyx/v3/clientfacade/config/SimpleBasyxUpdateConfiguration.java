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

import org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.config.AutoRegistrationConfig;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.config.SimpleAutoRegistrationConfig;

public class SimpleBasyxUpdateConfiguration extends SimpleBasyxServiceConfiguration implements BasyxUpdateConfiguration {

	private String aasRepoUrl;
	private String submodelRepoUrl;
	
	public static final SimpleBasyxUpdateConfiguration forEnvironmentUrl(String url) {
		return new SimpleBasyxUpdateConfiguration().withAasRepositoryUrl(url).withSubmodelRepositoryUrl(url);
	}
	
	public SimpleBasyxUpdateConfiguration withAasRepositoryUrl(String url) {
		this.aasRepoUrl = url;
		return this;
	}

	@Override
	public String getAasRepositoryUrl() {
		return aasRepoUrl;
	}
	
	public SimpleBasyxUpdateConfiguration withSubmodelRepositoryUrl(String url) {
		this.submodelRepoUrl = url;
		return this;
	}
	
	@Override
	public String getSubmodelRepositoryUrl() {
		return submodelRepoUrl;
	}
	
	public void setSubmodelRepoUrl(String submodelRepoUrl) {
		this.submodelRepoUrl = submodelRepoUrl;
	}
	
	@Override
	public AutoRegistrationConfig getAutoRegistrationConfig() {
		return new SimpleAutoRegistrationConfig();
	}
}
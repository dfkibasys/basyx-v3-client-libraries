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
package org.eclipse.digitaltwin.basyx.v3.clientfacade.registration.config;

import java.util.List;
import java.util.function.Supplier;

import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.EnvironmentVars;

public class EnvironmentBasedAutoRegistrationConfig implements AutoRegistrationConfig {

	private static final String ENV_AUTO_REGISTRATION_AAS_ENDPOINTS = "BASYX_CLIENT_AUTO_REGISTRATION_AAS_ENDPOINTS";
	private static final String ENV_AUTO_REGISTRATION_SUBMODEL_ENDPOINTS = "BASYX_CLIENT_AUTO_REGISTRATION_SUBMODEL_ENDPOINTS";
	private static final String ENV_AUTO_REGISTRATION_ENABLED = "BASYX_CLIENT_AUTO_REGISTRATION_ENABLED";
	
	@Override
	public List<String> getAasHrefs() {
		return assertValid(EnvironmentVars.getConfigList(ENV_AUTO_REGISTRATION_AAS_ENDPOINTS)
				, ()->"No aas hrefs set for auto configuration: " + ENV_AUTO_REGISTRATION_AAS_ENDPOINTS);
	}
	
	@Override
	public List<String> getSubmodelHrefs() {
		return assertValid(EnvironmentVars.getConfigList(ENV_AUTO_REGISTRATION_SUBMODEL_ENDPOINTS)
				, ()->"No submodel hrefs set for auto configuration: " + ENV_AUTO_REGISTRATION_SUBMODEL_ENDPOINTS);
	}

	private List<String> assertValid(List<String> configList, Supplier<String> errorMsgSupplier) {
		if (isEnabled() && (configList == null || configList.isEmpty())) {
			throw new IllegalAutoRegistrationConfiguration(errorMsgSupplier.get());
		}
		return configList;
	}

	@Override
	public boolean isEnabled() {
		return EnvironmentVars.getBooleanOrDefault(ENV_AUTO_REGISTRATION_ENABLED, false);
	}
	
	private static final class IllegalAutoRegistrationConfiguration extends IllegalArgumentException {

		private static final long serialVersionUID = 1L;
		
		public IllegalAutoRegistrationConfiguration(String msg) {
			super(msg);
		}
		
	}
}
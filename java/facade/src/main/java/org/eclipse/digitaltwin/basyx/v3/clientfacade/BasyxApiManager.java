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
package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxApiConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clients.api.*;

public interface BasyxApiManager {
	BasyxApiConfiguration getConfig();

	ObjectMapper getMapper();

	AssetAdministrationShellRegistryApi getShellRegistryApi();
	AssetAdministrationShellRegistryApi getShellRegistryApi(String baseUrl);

	SubmodelRegistryApi getSubmodelRegistryApi();
	SubmodelRegistryApi getSubmodelRegistryApi(String baseUrl);

	AssetAdministrationShellRepositoryApi getShellRepositoryApi();
	AssetAdministrationShellRepositoryApi getShellRepositoryApi(String baseUrl);

	SubmodelRepositoryApi getSubmodelRepositoryApi();
	SubmodelRepositoryApi getSubmodelRepositoryApi(String baseUrl);

	AasxFileServerApi getAasxFileServerApi();
	AasxFileServerApi getAasxFileServerApi(String baseUrl);

}

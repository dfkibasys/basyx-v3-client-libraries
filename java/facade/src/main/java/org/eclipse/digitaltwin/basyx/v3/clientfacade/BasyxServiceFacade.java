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

import java.util.Optional;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetKind;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints.EndpointResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.references.SubmodelReferenceResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxIterable;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.SortDirection;

public interface BasyxServiceFacade {

	BasyxIterable<AssetAdministrationShell> getAllShells();

	BasyxIterable<AssetAdministrationShell> getAllShells(AssetKind assetKind, String assetType);

	BasyxIterable<Submodel> getAllSubmodels(AssetAdministrationShell shell);
	
	BasyxIterable<SubmodelElement> getAllSubmodelElements(Submodel sm);
	
	BasyxIterable<String> getAllSubmodelElementPaths(Submodel sm);
	
	BasyxIterable<Reference> getAllSubmodelElementReferences(Submodel sm);

	BasyxIterable<Submodel> getAllSubmodels();

	Optional<AssetAdministrationShell> getShellById(String id);

	Optional<Submodel> getSubmodelById(String id);
	
	Optional<Submodel> getSubmodelByReference(Reference ref);

	BasyxIterable<AssetAdministrationShell> findShellsByIdShort(String idShort);

	BasyxIterable<AssetAdministrationShell> findShellsByIdShortRegex(String idShortRegex);

	BasyxIterable<AssetAdministrationShell> findShellsByIdShortRegex(String idShortRegex, SortDirection direction);

	BasyxIterable<AssetAdministrationShell> findShellsByIdShort(String idShort, SortDirection direction);

	Optional<SubmodelElement> getSubmodelElementByIdShortPath(Submodel sm, String idShortPath);

	<T extends SubmodelElement> Optional<T> getSubmodelElementByIdShortPath(Submodel sm, String idShortPath, Class<T> resultCls);

	BasyxServiceFacade withSubmodelResolver(SubmodelReferenceResolver smReferenceResolver);

	BasyxServiceFacade withEndpointResolver(EndpointResolver endpointResolverStrategy);
	

}
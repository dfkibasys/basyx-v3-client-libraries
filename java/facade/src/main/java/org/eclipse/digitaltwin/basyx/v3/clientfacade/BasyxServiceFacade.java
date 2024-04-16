package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import java.util.Optional;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetKind;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxIterable;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.SortDirection;

public interface BasyxServiceFacade {

	BasyxIterable<AssetAdministrationShell> getAllShells() throws ApiException;

	BasyxIterable<AssetAdministrationShell> getAllShells(AssetKind assetKind, String assetType) throws ApiException;

	BasyxIterable<Submodel> getAllSubmodels(AssetAdministrationShell shell);
	
	BasyxIterable<SubmodelElement> getAllSubmodelElements(Submodel sm);
	
	BasyxIterable<String> getAllSubmodelElementPaths(Submodel sm);

	BasyxIterable<Submodel> getAllSubmodels();

	AssetAdministrationShell getShellById(String id);

	Submodel getSubmodelById(String id);

	BasyxIterable<AssetAdministrationShell> findShellsByIdShort(String idShort);

	BasyxIterable<AssetAdministrationShell> findShellsByIdShortRegex(String idShortRegex);

	BasyxIterable<AssetAdministrationShell> findShellsByIdShortRegex(String idShortRegex, SortDirection direction);

	BasyxIterable<AssetAdministrationShell> findShellsByIdShort(String idShort, SortDirection direction);

	Optional<SubmodelElement> getSubmodelElementByIdShort(Submodel sm, String idShortPath);	
}

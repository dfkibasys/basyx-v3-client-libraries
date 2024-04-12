package org.eclipse.gigitaltwin.basyx.v3.clientfacade.cache;

import java.util.function.Function;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;

public interface BasyxClientCache {

	AssetAdministrationShell getShellById(String id, Function<String, AssetAdministrationShell> resolver);
	
	Submodel getSubmodelById(String id, Function<String, Submodel> resolver);
	
	Submodel getSubmodelByReference(Reference ref, Function<Reference, Submodel> resolver);
	
	void invalidateShell(AssetAdministrationShell shell);
	
	void invalidateSubmodel(Submodel sm);	
	
}

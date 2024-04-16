package org.eclipse.digitaltwin.basyx.v3.clientfacade.cache;

import java.util.function.Function;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;

public class PassThroughBasyxClientCache implements BasyxClientCache {

	@Override
	public AssetAdministrationShell getShellById(String id,Function<String, AssetAdministrationShell> resolver) {
		return resolver.apply(id);
	}
	
	@Override
	public Submodel getSubmodelById(String id, Function<String, Submodel> resolver) {
		return resolver.apply(id);
	}
	
	@Override
	public Submodel getSubmodelByReference(Reference ref, Function<Reference, Submodel> resolver) {
		return resolver.apply(ref);
	}

	@Override
	public void invalidateShell(AssetAdministrationShell shell) {
	}

	@Override
	public void invalidateSubmodel(Submodel sm) {
	}
}

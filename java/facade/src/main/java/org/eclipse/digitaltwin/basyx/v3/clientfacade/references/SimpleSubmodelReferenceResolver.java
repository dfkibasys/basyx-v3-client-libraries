package org.eclipse.digitaltwin.basyx.v3.clientfacade.references;

import java.util.List;

import org.eclipse.digitaltwin.aas4j.v3.model.Key;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelDescriptor;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRegistryApi;

public class SimpleSubmodelReferenceResolver implements SubmodelDescriptorResolver {

	@Override
	public SubmodelDescriptor resolveSubmodelDescriptor(SubmodelRegistryApi smRegistryApi, Reference ref) {
		List<Key> keys =  ref.getKeys();
		if (keys == null  || keys.isEmpty()) {
			return null;
		}
		Key key = keys.get(0);
		String value = key.getValue();		
		return smRegistryApi.getSubmodelDescriptorById(value);
	}

}

package org.eclipse.digitaltwin.basyx.v3.clientfacade.references;

import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelDescriptor;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRegistryApi;

public interface SubmodelDescriptorResolver {

	SubmodelDescriptor resolveSubmodelDescriptor(SubmodelRegistryApi smRegistryApi, Reference ref);
	
}

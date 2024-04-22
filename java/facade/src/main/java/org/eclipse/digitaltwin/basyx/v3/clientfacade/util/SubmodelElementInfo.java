package org.eclipse.digitaltwin.basyx.v3.clientfacade.util;

import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;

public interface SubmodelElementInfo {

	String getPath();
	
	Reference getReference();
	
	SubmodelElement get();
	
}
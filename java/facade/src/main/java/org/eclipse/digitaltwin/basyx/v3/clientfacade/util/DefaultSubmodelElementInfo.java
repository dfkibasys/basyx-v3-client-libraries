package org.eclipse.digitaltwin.basyx.v3.clientfacade.util;

import org.eclipse.digitaltwin.aas4j.v3.dataformat.core.util.AasUtils;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;

public class DefaultSubmodelElementInfo implements SubmodelElementInfo {

	private final String path;
	private final Submodel parent;
	private final SubmodelElement element;
	private Reference reference;
	
	public DefaultSubmodelElementInfo(Submodel parent, SubmodelElement element, String path) {
		this.parent = parent;
		this.element = element;
		this.path = path;
	}
	
	@Override
	public String getPath() {
		return path;
	}

	@Override
	public Reference getReference() {
		if (this.reference == null) {
			Reference parentRef = AasUtils.toReference(parent); 
			reference = AasUtils.toReference(parentRef, element);
		}
		return reference;
	}

	@Override
	public SubmodelElement get() {
		return element;
	}

}

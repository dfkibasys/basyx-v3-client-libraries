package org.eclipse.digitaltwin.basyx.v3.clientfacade.util;

import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;

public abstract class SubmodelElementVisitor {

	public abstract ProcessInstruction startElement(SubmodelElement parent);

	public void endElement() {
	}

	public void startCollection() {
	}

	public void endCollection() {
	}

	public static enum ProcessInstruction {
		CONTINUE, SKIP, STOP
	}

}

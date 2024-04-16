package org.eclipse.digitaltwin.basyx.v3.clientfacade.util;

import java.util.List;

import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.SubmodelElementVisitor.ProcessInstruction;

public class SubmodelElementWalker {

	private final SubmodelElementVisitor visitor;
	private final SubmodelElementHierarchyResolver resolver;

	public SubmodelElementWalker(SubmodelElementVisitor visitor, SubmodelElementHierarchyResolver resolver) {
		this.visitor = visitor;
		this.resolver = resolver;
	}

	public void walkSubmodel(Submodel sm) {
		List<SubmodelElement> elements = sm.getSubmodelElements();
		if (elements == null || elements.isEmpty()) {
			return;
		}
		walkElements(null, elements);

	}

	private ProcessInstruction walkElements(SubmodelElement parent, List<? extends SubmodelElement> children) {			
		if (parent != null) {
			ProcessInstruction instruction = visitor.startElement(parent);
			if (instruction != ProcessInstruction.CONTINUE) {
				return instruction;
			}
		}
		if (children == null || children.isEmpty()) {
			return ProcessInstruction.CONTINUE;
		}
		visitor.startCollection();
		try {
			for (SubmodelElement eachElement : children) {
				ProcessInstruction instruction = walkElements(eachElement, resolver.getChildren(eachElement));
				if (instruction == ProcessInstruction.STOP) {
					return instruction;
				}
			}
		} finally {
			visitor.endCollection();
			if (parent != null) {
				visitor.endElement();
			}
		}
		return ProcessInstruction.CONTINUE;
	}
}

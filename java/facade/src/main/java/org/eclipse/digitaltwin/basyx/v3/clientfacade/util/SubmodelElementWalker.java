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

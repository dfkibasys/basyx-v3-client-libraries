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

import org.eclipse.digitaltwin.aas4j.v3.model.AnnotatedRelationshipElement;
import org.eclipse.digitaltwin.aas4j.v3.model.Entity;
import org.eclipse.digitaltwin.aas4j.v3.model.RelationshipElement;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElementCollection;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElementList;

public class SubmodelElementHierarchyResolver {

	public List<? extends SubmodelElement> getChildren(SubmodelElement elem) {
		if (elem instanceof Entity) {
			return getEntityChildren((Entity) elem);
		} else if (elem instanceof RelationshipElement) {
			return getRelationShipChildren((RelationshipElement) elem);
		} else if (elem instanceof SubmodelElementCollection) {
			return getCollectionChildren((SubmodelElementCollection) elem);
		} else if (elem instanceof SubmodelElementList) {
			return getListChildren((SubmodelElementList) elem);
		}
		return null;
	}

	private List<SubmodelElement> getEntityChildren(Entity elem) {
		return elem.getStatements();
	}

	private List<? extends SubmodelElement> getRelationShipChildren(RelationshipElement elem) {
		if (elem instanceof AnnotatedRelationshipElement) {
			AnnotatedRelationshipElement arAlem = (AnnotatedRelationshipElement) elem;
			return arAlem.getAnnotations();
		}
		return null;
	}

	private List<SubmodelElement> getCollectionChildren(SubmodelElementCollection elem) {
		return elem.getValue();
	}

	private List<SubmodelElement> getListChildren(SubmodelElementList elem) {
		return elem.getValue();
	}

}

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

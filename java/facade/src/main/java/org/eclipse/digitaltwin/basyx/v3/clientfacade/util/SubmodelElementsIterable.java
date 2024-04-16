package org.eclipse.digitaltwin.basyx.v3.clientfacade.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;

public class SubmodelElementsIterable implements BasyxIterable<SubmodelElement> {
	
	private final Submodel submodel;
	
	public SubmodelElementsIterable (Submodel submodel) {
		this.submodel = submodel;
	}
	
	@Override
	public Iterator<SubmodelElement> iterator() {
		return new SubmodelElementIterator(submodel);
	}

	@Override
	public Stream<SubmodelElement> stream() {
		return StreamSupport.stream(spliterator(), false);
	}
	
	public static class SubmodelElementIterator implements Iterator<SubmodelElement> {

		private Deque<Iterator<? extends SubmodelElement>> iterators = new ArrayDeque<Iterator<? extends SubmodelElement>>();
		private SubmodelElementHierarchyResolver resolver = new SubmodelElementHierarchyResolver();

		public SubmodelElementIterator(Submodel submodel) {
			List<SubmodelElement> elements = submodel.getSubmodelElements();
			if (elements != null) {
				iterators.add(submodel.getSubmodelElements().iterator());
			}
		}

		@Override
		public boolean hasNext() {
			while (!iterators.isEmpty()) {
				Iterator<?> iter = iterators.peek();
				if (!iter.hasNext()) {
					iterators.pop();
				} else {
					return true;
				}
			}
			return false;
		}

		@Override
		public SubmodelElement next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			SubmodelElement elem = iterators.peek().next();
			offerIterator(elem);
			return elem;
		}

		private void offerIterator(SubmodelElement elem) {
			List<? extends SubmodelElement> elements = resolver.getChildren(elem);
			if (elements != null && ! elements.isEmpty()) {
				this.iterators.add(elements.iterator());
			}
		}
	}
}
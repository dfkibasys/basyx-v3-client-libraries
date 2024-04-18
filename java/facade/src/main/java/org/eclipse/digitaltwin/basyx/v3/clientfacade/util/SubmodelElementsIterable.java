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
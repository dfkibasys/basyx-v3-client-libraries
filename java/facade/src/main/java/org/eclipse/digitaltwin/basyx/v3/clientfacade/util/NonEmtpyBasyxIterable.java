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

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.digitaltwin.aas4j.v3.model.Identifiable;

class NonEmtpyBasyxIterable<T extends Identifiable> implements BasyxIterable<T> {

	private final Iterator<Optional<T>> input;
	
	public NonEmtpyBasyxIterable(Iterator<Optional<T>> input) {
		this.input = input;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new OptionalBasyxIterator<>(input);
	}

	@Override
	public Stream<T> stream() {
		return StreamSupport.stream(spliterator(), false);
	}
	
	private static final class OptionalBasyxIterator<T extends Identifiable> implements Iterator<T> {

		private final Iterator<Optional<T>> input;
		
		private T next;
		
		public OptionalBasyxIterator(Iterator<Optional<T>> input) {
			this.input = input;
		}
		
		@Override
		public boolean hasNext() {
			if (next == null) {
				resolveNext();
			}
			return next != null;
		}

		private void resolveNext() {
			while (input.hasNext()) {
				Optional<T> item = input.next();
				if (item.isPresent()) {
					next = item.get();
					return;
				}
			}
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T toReturn = next;
			next = null;
			return toReturn;
		}
		
	}

}

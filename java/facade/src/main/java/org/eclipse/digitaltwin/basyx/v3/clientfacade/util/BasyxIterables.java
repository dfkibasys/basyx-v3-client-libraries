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
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.digitaltwin.aas4j.v3.model.Identifiable;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;

public class BasyxIterables {

	private BasyxIterables() {		
	}

	public static <I, T> BasyxIterable<T> getMappingIterable(Iterator<I> input, Function<I, T> mapper) {		
		return new MappingBasyxIterable<>(input, mapper);
	}
	
	public static <I, T extends Identifiable> BasyxIterable<T> getMappingNonEmptyIterable(Iterator<I> input, Function<I, Optional<T>> mapper) {		
		MappingBasyxIterable<I, Optional<T>> mappingIterable = new MappingBasyxIterable<>(input, mapper);		
		return new NonEmtpyBasyxIterable<T>(mappingIterable.iterator());		
	}
	
	public static BasyxIterable<SubmodelElementInfo> getElementInfoIterable(Submodel sm) {
		return new SubmodelElementInfoIterable(sm);
	}
	
	public static <T> BasyxCollectionIterable<T> empty() {
		return new BasyxCollectionIterable<T>(List.of());
	}
	
	public static <T> BasyxCollectionIterable<T> of(List<T> list) {
		return new BasyxCollectionIterable<T>(list);
	}
	
	public static <C, T> BasyxIterable<T> fetchingIterable(ResultResolver<C, T> resolver) {
		return new FetchingBasyxIterable<C, T>(resolver);
	}
}
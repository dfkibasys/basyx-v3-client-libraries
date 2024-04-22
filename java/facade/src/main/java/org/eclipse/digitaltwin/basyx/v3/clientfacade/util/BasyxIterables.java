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
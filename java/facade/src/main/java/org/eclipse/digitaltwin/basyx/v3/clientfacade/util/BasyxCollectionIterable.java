package org.eclipse.digitaltwin.basyx.v3.clientfacade.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class BasyxCollectionIterable<T> implements BasyxIterable<T> {

	private final Collection<T> collection;
	
	public BasyxCollectionIterable(Collection<T> collection) {
		this.collection = collection;
	}
	
	public static final <T> BasyxCollectionIterable<T> empty() {
		return new BasyxCollectionIterable<T>(List.of());
	}
	
	public static final <T> BasyxCollectionIterable<T> of(List<T> list) {
		return new BasyxCollectionIterable<T>(list);
	}
	
	@Override
	public Iterator<T> iterator() {
		return collection.iterator();
	}

	@Override
	public Stream<T> stream() {
		return collection.stream();
	}

}

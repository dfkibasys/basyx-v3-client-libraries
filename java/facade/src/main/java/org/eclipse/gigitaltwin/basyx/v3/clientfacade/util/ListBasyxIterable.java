package org.eclipse.gigitaltwin.basyx.v3.clientfacade.util;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ListBasyxIterable<T> implements BasyxIterable<T> {

	private final List<T> list;
	
	public ListBasyxIterable(List<T> list) {
		this.list = list;
	}
	
	public static final <T> ListBasyxIterable<T> empty() {
		return new ListBasyxIterable<T>(List.of());
	}
	
	public static final <T> ListBasyxIterable<T> of(List<T> list) {
		return new ListBasyxIterable<T>(list);
	}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public Stream<T> stream() {
		return list.stream();
	}

}

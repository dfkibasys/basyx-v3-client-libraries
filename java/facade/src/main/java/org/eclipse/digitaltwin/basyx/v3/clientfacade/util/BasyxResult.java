package org.eclipse.digitaltwin.basyx.v3.clientfacade.util;

import java.util.Iterator;
import java.util.List;

public class BasyxResult<C, T> {
	
	private final C cursor;
	private final List<T> result;

	public BasyxResult(C cursor, List<T> result) {
		this.cursor = cursor;
		this.result = result == null ? List.of() : result;
	}

	public C cursor() {
		return cursor;
	}

	public List<T> result() {
		return result;
	}

	public Iterator<T> iterator() {
		return result.iterator();
	}
}

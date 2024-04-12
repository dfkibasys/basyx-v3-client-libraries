package org.eclipse.gigitaltwin.basyx.v3.clientfacade.util;

import java.util.stream.Stream;

public interface BasyxIterable<T> extends Iterable<T> {

	
	Stream<T> stream();
	
}

package org.eclipse.digitaltwin.basyx.v3.clientfacade.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FetchingBasyxIterable<C, T> implements BasyxIterable<T> {

	private final ResultResolver<C, T> resultResolver;

	public FetchingBasyxIterable(ResultResolver<C, T> resultResolver) {
		this.resultResolver = resultResolver;
	}

	@Override
	public Iterator<T> iterator() {
		return new BasyxIterator<C, T>(resultResolver);
	}
	
	@Override
	public Stream<T> stream() {
		return StreamSupport.stream(spliterator(), false);
	}

	public static class BasyxIterator<C, T> implements Iterator<T> {

		private final ResultResolver<C, T> resultResolver;

		private C cursor;
		private Iterator<T> iterator;

		private BasyxIterator(ResultResolver<C, T> resultResolver) {
			this.resultResolver = resultResolver;
		}

		@Override
		public boolean hasNext() {
			while (iterator == null || (!iterator.hasNext() && cursor != null)) {
				BasyxResult<C, T> result = resultResolver.fetchResult(cursor);
				this.cursor = result.cursor();
				this.iterator = result.iterator();
			}
			return iterator.hasNext();
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return iterator.next();
		}
	}
}
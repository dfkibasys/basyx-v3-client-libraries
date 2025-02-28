package org.eclipse.digitaltwin.basyx.v3.testenvironment.model;

import java.util.List;

public class PagedResult<T> {

	private List<T> result;

	private PagingMetadata paging_metadata;

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public PagingMetadata getPaging_metadata() {
		return paging_metadata;
	}
	
	public void setPaging_metadata(PagingMetadata paging_metadata) {
		this.paging_metadata = paging_metadata;
	}

	public static class PagingMetadata {

		private String cursor;

		public String getCursor() {
			return cursor;
		}

		public void setCursor(String cursor) {
			this.cursor = cursor;
		}
	}
}

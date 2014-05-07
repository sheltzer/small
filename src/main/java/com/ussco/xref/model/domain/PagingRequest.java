package com.ussco.xref.model.domain;

import java.io.Serializable;

public class PagingRequest implements Serializable {

	private static final long serialVersionUID = -7072133219776327637L;

	private int pageNumber;
	private int numberOfResultsToFetch;

	public int getPageNumber() {
		return this.pageNumber;
	}

	public int getNumberOfResultsToFetch() {
		return this.numberOfResultsToFetch;
	}

	public void setPageNumber(final int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setNumberOfResultsToFetch(final int numberOfResultsToFetch) {
		this.numberOfResultsToFetch = numberOfResultsToFetch;
	}
}

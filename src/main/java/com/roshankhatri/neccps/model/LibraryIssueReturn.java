package com.roshankhatri.neccps.model;

import java.util.Date;

public class LibraryIssueReturn {
	private long libraryItemId;
	private long issuedReturned;
	private Date issuedReturnedDate;
	
	public long getLibraryItemId() {
		return libraryItemId;
	}
	public void setLibraryItemId(long libraryItemId) {
		this.libraryItemId = libraryItemId;
	}
	public long getIssuedReturned() {
		return issuedReturned;
	}
	public void setIssuedReturned(long issuedReturned) {
		this.issuedReturned = issuedReturned;
	}
	public Date getIssuedReturnedDate() {
		return issuedReturnedDate;
	}
	public void setIssuedReturnedDate(Date issuedReturnedDate) {
		this.issuedReturnedDate = issuedReturnedDate;
	}

}

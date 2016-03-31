package com.roshankhatri.neccps.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class IssueReturn {
	private long libraryItemId;
	private Long issuedReturned;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date issuedReturnedDate;
	private String issueReturnStatus;
	private Student student;

	public long getLibraryItemId() {
		return libraryItemId;
	}
	public void setLibraryItemId(long libraryItemId) {
		this.libraryItemId = libraryItemId;
	}
	public Long getIssuedReturned() {
		return issuedReturned;
	}
	public void setIssuedReturned(Long issuedReturned) {
		this.issuedReturned = issuedReturned;
	}
	public Date getIssuedReturnedDate() {
		return issuedReturnedDate;
	}
	public void setIssuedReturnedDate(Date issuedReturnedDate) {
		this.issuedReturnedDate = issuedReturnedDate;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getIssueReturnStatus() {
		return issueReturnStatus;
	}
	public void setIssueReturnStatus(String issueReturnStatus) {
		this.issueReturnStatus = issueReturnStatus;
	}
}

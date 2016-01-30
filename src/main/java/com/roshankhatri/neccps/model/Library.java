package com.roshankhatri.neccps.model;

import java.util.HashSet;
import java.util.Set;

public class Library {
	private long id;
	private long libraryTotal;
	private Student student;
	private Set<LibraryIssueReturn> libraryIssueReturns=new HashSet<LibraryIssueReturn>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getLibraryTotal() {
		return libraryTotal;
	}
	public void setLibraryTotal(long libraryTotal) {
		this.libraryTotal = libraryTotal;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Set<LibraryIssueReturn> getLibraryIssueReturns() {
		return libraryIssueReturns;
	}
	public void setLibraryIssueReturns(Set<LibraryIssueReturn> libraryIssueReturns) {
		this.libraryIssueReturns = libraryIssueReturns;
	}
}

package com.roshankhatri.neccps.model;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private long id;
	private String firstname;
	private String lastname;
	private Thesis thesis;
	private Batch batch;
	private long payableAmount;
	private long issueableBooks;
	private Set<Payment> payments=new HashSet<Payment>();
	private Set<IssueReturn> issueReturns=new HashSet<IssueReturn>();
	private Set<ExamResult> examResults=new HashSet<ExamResult>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Thesis getThesis() {
		return thesis;
	}
	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	public long getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(long payableAmount) {
		this.payableAmount = payableAmount;
	}
	public long getIssueableBooks() {
		return issueableBooks;
	}
	public void setIssueableBooks(long issueableBooks) {
		this.issueableBooks = issueableBooks;
	}
	public Set<Payment> getPayments() {
		return payments;
	}
	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	public Set<IssueReturn> getIssueReturns() {
		return issueReturns;
	}
	public void setIssueReturns(Set<IssueReturn> issueReturns) {
		this.issueReturns = issueReturns;
	}
	public Set<ExamResult> getExamResults() {
		return examResults;
	}
	public void setExamResults(Set<ExamResult> examResults) {
		this.examResults = examResults;
	}

}

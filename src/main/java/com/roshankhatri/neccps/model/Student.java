package com.roshankhatri.neccps.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student {
	private long id;
	private String firstname;
	private String lastname;
	@JsonIgnore
	private Batch batch;
	private Parent parent;
	private Degree degree;
	private ThesisM thesism;
	private Long payableAmount;
	private Long issueableBooks;
	private Address address;
	private Contact contact;
	private Account account;
	@JsonIgnore
	private Set<Payment> payments=new HashSet<Payment>();
	@JsonIgnore
	private Set<IssueReturn> issueReturns=new HashSet<IssueReturn>();
	@JsonIgnore
	private Set<ExamResult> examResults=new HashSet<ExamResult>();
	@JsonIgnore
	private Set<Thesis> thesisHistory=new HashSet<Thesis>();
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
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Long getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(Long payableAmount) {
		this.payableAmount = payableAmount;
	}
	public Long getIssueableBooks() {
		return issueableBooks;
	}
	public void setIssueableBooks(Long issueableBooks) {
		this.issueableBooks = issueableBooks;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public Degree getDegree() {
		return degree;
	}
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	public ThesisM getThesism() {
		return thesism;
	}
	public void setThesism(ThesisM thesism) {
		this.thesism = thesism;
	}
	public Set<Thesis> getThesisHistory() {
		return thesisHistory;
	}
	public void setThesisHistory(Set<Thesis> thesisHistory) {
		this.thesisHistory = thesisHistory;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

}

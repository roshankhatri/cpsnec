package com.roshankhatri.neccps.model;

import java.util.HashSet;
import java.util.Set;


public class Account {
	private long id;
	private long payableDues;
	private Student student;
	private Set<AccountPayment> payments=new HashSet<AccountPayment>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPayableDues() {
		return payableDues;
	}
	public void setPayableDues(long payableDues) {
		this.payableDues = payableDues;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Set<AccountPayment> getPayments() {
		return payments;
	}
	public void setPayments(Set<AccountPayment> payments) {
		this.payments = payments;
	}
	public void addAccountPayment(AccountPayment accountPaymentItem) {
		accountPaymentItem.setAccount(this);
		payments.add(accountPaymentItem);
		
	}
}

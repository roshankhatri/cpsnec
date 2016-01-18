package com.roshankhatri.neccps.model;

import java.util.Date;

public class Account {
	private long id;
	private long payableDues;
	private long paidDues;
	private Date lastPaid;
	private Student student;
	
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
	public long getPaidDues() {
		return paidDues;
	}
	public void setPaidDues(long paidDues) {
		this.paidDues = paidDues;
	}
	public Date getLastPaid() {
		return lastPaid;
	}
	public void setLastPaid(Date lastPaid) {
		this.lastPaid = lastPaid;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}

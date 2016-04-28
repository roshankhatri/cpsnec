package com.roshankhatri.neccps.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Payment {
	private long accountPaymentId;
	private Long paidAmount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date paidDate;
	private Long semester;
	private Student student;
	
	public long getAccountPaymentId() {
		return accountPaymentId;
	}
	public void setAccountPaymentId(long accountPaymentId) {
		this.accountPaymentId = accountPaymentId;
	}
	public Long getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Long paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Long getSemester() {
		return semester;
	}
	public void setSemester(Long semester) {
		this.semester = semester;
	}

}

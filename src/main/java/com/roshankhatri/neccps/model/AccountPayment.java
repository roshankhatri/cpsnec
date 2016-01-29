package com.roshankhatri.neccps.model;

import java.util.Date;

public class AccountPayment {
	private long accountPaymentId;
	private long paidAmount;
	private Date paidDate;
	private Account account;
	
	public long getAccountPaymentId() {
		return accountPaymentId;
	}
	public void setAccountPaymentId(long accountPaymentId) {
		this.accountPaymentId = accountPaymentId;
	}
	public long getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(long paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

}

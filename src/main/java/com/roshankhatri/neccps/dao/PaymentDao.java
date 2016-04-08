package com.roshankhatri.neccps.dao;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.roshankhatri.neccps.model.Payment;

public interface PaymentDao {
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<Payment> listall();
	@PreAuthorize("hasRole('ADMIN') OR hasRole('PAY')")
	void save(Payment Payment);
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<Payment> listbyStudent(long studentId);
	long getCount();
}

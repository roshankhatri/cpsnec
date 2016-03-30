package com.roshankhatri.neccps.dao;

import java.util.List;
import com.roshankhatri.neccps.model.Payment;

public interface PaymentDao {
	List<Payment> listall();
	void save(Payment Payment);
	List<Payment> listbyStudent(long studentId);

}

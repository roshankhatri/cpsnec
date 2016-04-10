package com.roshankhatri.neccps.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.roshankhatri.neccps.model.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List<Payment> listall() {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Payment> payments=session.createQuery("from Payment p").list();
		transaction.commit();
		return payments;
	}
	public void save(Payment payment) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.persist(payment);
		transaction.commit();
	}
	public List<Payment> listbyStudent(long studentId){
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query = session.createQuery("from Payment where STUDENT_ID=:id");
		query.setLong("id", studentId);
		@SuppressWarnings("unchecked")
		List<Payment> payments  = query.list();
		transaction.commit();
		return payments;
		
	}

	@Override
	public long getCount() {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("select count(*) from Payment");
		long countPayments=(Long) query.uniqueResult();
		transaction.commit();
		return countPayments;
	}

}

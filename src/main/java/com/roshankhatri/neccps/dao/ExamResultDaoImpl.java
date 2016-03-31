package com.roshankhatri.neccps.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.roshankhatri.neccps.model.ExamResult;

@Repository
public class ExamResultDaoImpl implements ExamResultDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public List<ExamResult> listall() {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<ExamResult> examResults=session.createQuery("from ExamResult e").list();
		transaction.commit();
		return examResults;
	}

	@Override
	public void save(ExamResult examResult) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.persist(examResult);
		transaction.commit();
		
	}

	@Override
	public List<ExamResult> listbyStudent(long studentId) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query = session.createQuery("from ExamResult where STUDENT_ID=:id");
		query.setLong("id", studentId);
		@SuppressWarnings("unchecked")
		List<ExamResult> examResults  = query.list();
		transaction.commit();
		return examResults;
	}

}

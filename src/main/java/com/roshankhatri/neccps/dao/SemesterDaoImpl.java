package com.roshankhatri.neccps.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.roshankhatri.neccps.model.Semester;

@Repository
public class SemesterDaoImpl implements SemesterDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public void save(Semester semester) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.persist(semester);
		transaction.commit();
	}
	@Override
	public List<Semester> getByBatchId(long batchId) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Semester where BATCH_ID=:id");
		query.setLong("id", batchId);
		@SuppressWarnings("unchecked")
		List<Semester> semesters=query.list();
		transaction.commit();
		return semesters;
	}
	@Override
	public void update(Semester semester) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.update(semester);
		transaction.commit();
	}

}

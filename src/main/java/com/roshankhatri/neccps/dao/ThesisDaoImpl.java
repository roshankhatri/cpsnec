package com.roshankhatri.neccps.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.roshankhatri.neccps.model.Thesis;
@Repository
public class ThesisDaoImpl implements ThesisDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public List<Thesis> listall() {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Thesis> thesises=session.createQuery("from Thesis t").list();
		transaction.commit();
		return thesises;
	}

	@Override
	public void save(Thesis thesis) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.persist(thesis);
		transaction.commit();
	}

	@Override
	public List<Thesis> listbyStudent(long studentId) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Thesis where STUDENT_ID=:id");
		query.setLong("id",studentId );
		@SuppressWarnings("unchecked")
		List<Thesis> thesises=query.list();
		transaction.commit();
		return thesises;
	}
	@Override
	public Thesis getById(long thesisId) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Thesis thesis=(Thesis) session.get(Thesis.class,thesisId);
		transaction.commit();
		return thesis;
	}
	@Override
	public void updateThesis(Thesis thesis) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.update(thesis);
		transaction.commit();
	}

}

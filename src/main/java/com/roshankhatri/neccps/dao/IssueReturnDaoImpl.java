package com.roshankhatri.neccps.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.roshankhatri.neccps.model.IssueReturn;

@Repository
public class IssueReturnDaoImpl implements IssueReturnDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<IssueReturn> listall() {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<IssueReturn> issueReturns=session.createQuery("from IssueReturn i").list();
		transaction.commit();
		return issueReturns;
	}

	@Override
	public void save(IssueReturn issueReturn) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.persist(issueReturn);
		transaction.commit();
	}

	@Override
	public List<IssueReturn> listbyStudent(long studentId) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query = session.createQuery("from IssueReturn where STUDENT_ID=:id");
		query.setLong("id", studentId);
		@SuppressWarnings("unchecked")
		List<IssueReturn> issueReturns = query.list();
		transaction.commit();
		return issueReturns;
	}	

}

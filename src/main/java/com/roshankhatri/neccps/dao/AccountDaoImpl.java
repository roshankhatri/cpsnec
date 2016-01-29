package com.roshankhatri.neccps.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.roshankhatri.neccps.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public long save(Account account) {

		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		long id = (long) account.getId();
		session.persist(account);
		transaction.commit();
		return id;
	}

	@Override
	public long update(Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		long id = (long) account.getId();
		session.update(account);
		transaction.commit();
		return id;
	}

}

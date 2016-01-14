package com.roshankhatri.neccps.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roshankhatri.neccps.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public void save(Student student) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(student);
		transaction.commit();
	}

}

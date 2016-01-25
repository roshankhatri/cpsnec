package com.roshankhatri.neccps.dao;

import java.util.List;

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
	public long save(Student student) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(student);
		long id=(long) student.getId();
		transaction.commit();
		return id;
	}

	@Override
	public Student getById(long id) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Student student=(Student)session.get(Student.class, id);
		transaction.commit();
		return student;
	}

	@Override
	public List<Student> getall() {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Student> students=session.createQuery("from Student").list();
		transaction.commit();
		return students;
	}

}

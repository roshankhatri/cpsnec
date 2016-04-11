package com.roshankhatri.neccps.dao;

import java.util.List;

import org.hibernate.Query;
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
	@Transactional
	public long save(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		long id = (long) student.getId();
		transaction.commit();
		return id;
	}

	public Student getById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, id);
		transaction.commit();
		return student;
	}

	public List<Student> getall() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Student> students = session.createQuery("from Student").list();
		transaction.commit();
		return students;
	}

	public List<Student> getByBatchId(long BatchId) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Student where BATCH_ID=:id");
		query.setLong("id", BatchId);
		@SuppressWarnings("unchecked")
		List<Student> students = query.list();
		transaction.commit();
		return students;
	}
	@Override
	public void update(Student student) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.update(student);
		transaction.commit();
	}
	@Override
	public long getCount() {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("select count(*) from Student");
		long countStudents=(Long) query.uniqueResult();
		transaction.commit();
		return countStudents;
	}
	@Override
	public List<Student> search(String searchStudent) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query = session.createQuery("from Student s where s.firstname like :searchStudent");
		query.setString("searchStudent", '%'+searchStudent+'%');
		@SuppressWarnings("unchecked")
		List<Student> students = query.list();
		transaction.commit();
		return students;
	}

}

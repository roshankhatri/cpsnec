package com.roshankhatri.neccps.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.roshankhatri.neccps.model.Course;

@Repository
public class CourseDaoImpl implements CourseDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Course> findByProgram(long programId) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Course c where PROGRAM_ID=:id");
		query.setLong("id", programId);
		@SuppressWarnings("unchecked")
		List<Course> courses=query.list();
		transaction.commit();
		return courses;
	}

	@Override
	public Course getById(long courseId) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Course course = (Course) session.get(Course.class, courseId);
		transaction.commit();
		return course;
	}

	@Override
	public Course getByCourseTitle(String courseTitle) {
		return null;
	}
	
}

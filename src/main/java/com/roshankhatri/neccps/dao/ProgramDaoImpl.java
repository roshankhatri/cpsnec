package com.roshankhatri.neccps.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.roshankhatri.neccps.model.Program;

@Repository
public class ProgramDaoImpl implements ProgramDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Transactional
	@Override
	public long save(Program program) {
		Session session=this.sessionFactory.getCurrentSession();
		System.out.println(program.getProgramName().toString());
		Transaction transaction=session.beginTransaction();
		long id=(long) program.getId();
		session.persist(program);
		transaction.commit();
		return id;
		
	}

	@Override
	public List<Program> listall() {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Program> programmes=session.createQuery("from Program").list();
		transaction.commit();
		return programmes;
	}

	@Override
	public Program getById(long id) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Program program=(Program) session.get(Program.class, id);
		transaction.commit();
		return program;
	}

	@Override
	public void update(Program program) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.update(program);
		transaction.commit();
	}

}

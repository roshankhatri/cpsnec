package com.roshankhatri.neccps.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.roshankhatri.neccps.model.Batch;

@Repository
public class BatchDaoImpl implements BatchDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	
	@Override
	public long save(Batch batch) {
		Session session=this.sessionFactory.getCurrentSession();
		//System.out.println(program.getProgramName().toString());
		Transaction transaction=session.beginTransaction();
		long id=(long) batch.getId();
		session.update(batch);;
		transaction.commit();
		return id;
		}

//	@Override
//	public List<Program> listall() {
//		Session session=this.sessionFactory.getCurrentSession();
//		Transaction transaction=session.beginTransaction();
//		@SuppressWarnings("unchecked")
//		List<Program> programmes=session.createQuery("from Program").list();
//		transaction.commit();
//		return programmes;
//	}

	@Override
	public Batch getById(long id) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Batch batch=(Batch) session.get(Batch.class, id);
		transaction.commit();
		return batch;
	}


	@Override
	public List<Batch> listall(long programId) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Batch where PROGRAM_ID=:id");
		query.setLong("id", programId);
		@SuppressWarnings("unchecked")
		List<Batch> batches=query.list();
		transaction.commit();
	 	return batches;
	}

//	@Override
//	public long update(Program program) {
//		Session session=this.sessionFactory.getCurrentSession();
//		Transaction transaction=session.beginTransaction();
//		long id=(long) program.getId();
//		session.update(program);
//		transaction.commit();
//		return id;
//	}

}

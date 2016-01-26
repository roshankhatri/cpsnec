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

	public List<Batch> listAllWithoutProgram() {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Batch> batches=session.createQuery("from Batch b order by PROGRAM_ID").list();
		transaction.commit();
		return batches;
	}

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
		Query query=session.createQuery("from Batch b where PROGRAM_ID=:id order by b.batchYear DESC");
		query.setLong("id", programId);
		@SuppressWarnings("unchecked")
		List<Batch> batches=query.list();
		transaction.commit();
	 	return batches;
	}

	@Override
	public long update(Batch batch) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		long id=(long) batch.getId();
		session.update(batch);
		transaction.commit();
		return id;
	}

}

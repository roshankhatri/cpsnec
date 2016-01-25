package com.roshankhatri.neccps.dao;

import java.util.List;

import com.roshankhatri.neccps.model.Batch;

public interface BatchDao {
	long save(Batch batch);
	List<Batch> listall(long programId);
	Batch getById(long id);
//	long update(Program program);

}

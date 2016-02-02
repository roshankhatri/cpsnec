package com.roshankhatri.neccps.dao;

import java.util.List;

import com.roshankhatri.neccps.model.Semester;

public interface SemesterDao {
	void save(Semester semester);
	List<Semester> getByBatchId(long batchId);
	void update(Semester semester);

}

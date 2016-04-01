package com.roshankhatri.neccps.dao;

import java.util.List;

import com.roshankhatri.neccps.model.Thesis;

public interface ThesisDao {
	List<Thesis> listall();
	void save(Thesis thesis);
	List<Thesis> listbyStudent(long StudentId);
	
}

package com.roshankhatri.neccps.dao;

import java.util.List;

import com.roshankhatri.neccps.model.Program;

public interface ProgramDao {
	long save(Program program);
	List<Program> listall();
	Program getById(long id);
	long update(Program program);

}

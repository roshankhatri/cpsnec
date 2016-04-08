package com.roshankhatri.neccps.dao;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.roshankhatri.neccps.model.Program;

public interface ProgramDao {
	@PreAuthorize("hasRole('ADMIN') OR hasRole('COORD')")
	long save(Program program);
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<Program> listall();
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	Program getById(long id);
	long update(Program program);
	long getCount();

}

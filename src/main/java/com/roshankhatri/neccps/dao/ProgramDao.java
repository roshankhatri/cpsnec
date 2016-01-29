package com.roshankhatri.neccps.dao;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.roshankhatri.neccps.model.Program;

public interface ProgramDao {
	@PreAuthorize("hasRole('ADMIN')")
	long save(Program program);
	@PreAuthorize("hasRole('ADMIN')")
	List<Program> listall();
	Program getById(long id);
	long update(Program program);

}

package com.roshankhatri.neccps.dao;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.roshankhatri.neccps.model.Batch;

public interface BatchDao {
	@PreAuthorize("hasRole('ADMIN') OR hasRole('COORD')")
	long save(Batch batch);
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<Batch> listall(long programId);
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	Batch getById(long id);
	@PreAuthorize("hasRole('COORD') OR hasRole('VIEW')")
	long update(Batch batch);
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<Batch> listAllWithoutProgram();

}

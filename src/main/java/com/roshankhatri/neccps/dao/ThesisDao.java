package com.roshankhatri.neccps.dao;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.roshankhatri.neccps.model.Thesis;

public interface ThesisDao {
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<Thesis> listall();
	@PreAuthorize("hasRole('ADMIN') OR hasRole('THESIS')")
	void save(Thesis thesis);
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<Thesis> listbyStudent(long StudentId);

	Thesis getById(long thesisId);
	void updateThesis(Thesis thesis);
	long getCount();
	
}

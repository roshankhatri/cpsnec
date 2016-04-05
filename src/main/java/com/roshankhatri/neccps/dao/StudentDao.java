package com.roshankhatri.neccps.dao;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.roshankhatri.neccps.model.Student;

public interface StudentDao {
	@PreAuthorize("hasRole('ADMIN') OR hasRole('SECRET')")
	long save(Student student);
	@PreAuthorize("hasRole('ADMIN') OR hasRole('BEL')")
	void update(Student student);
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	Student getById(long id);
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<Student> getall();
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<Student> getByBatchId(long BatchId);

}

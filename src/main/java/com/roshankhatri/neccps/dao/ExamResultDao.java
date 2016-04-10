package com.roshankhatri.neccps.dao;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.roshankhatri.neccps.model.ExamResult;

public interface ExamResultDao {
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<ExamResult> listall();
	@PreAuthorize("hasRole('ADMIN') OR hasRole('EXAM')")
	void save(ExamResult examResult);
	@PreAuthorize("hasRole('ADMIN') OR hasRole('VIEW')")
	List<ExamResult> listbyStudent(long studentId);
	long getCount();
}

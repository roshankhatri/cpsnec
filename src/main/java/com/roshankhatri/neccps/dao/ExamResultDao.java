package com.roshankhatri.neccps.dao;

import java.util.List;

import com.roshankhatri.neccps.model.ExamResult;

public interface ExamResultDao {
	List<ExamResult> listall();
	void save(ExamResult examResult);
	List<ExamResult> listbyStudent(long studentId);
}

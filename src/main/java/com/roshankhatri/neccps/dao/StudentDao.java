package com.roshankhatri.neccps.dao;

import java.util.List;

import com.roshankhatri.neccps.model.Student;

public interface StudentDao {
	long save(Student student);
	Student getById(long id);
	List<Student> getall();

}

package com.roshankhatri.neccps.dao;

import java.util.List;

import com.roshankhatri.neccps.model.Course;

public interface CourseDao {
	List<Course> findByProgram(long programId);
	Course getById(long courseId);
	Course getByCourseTitle(String courseTitle);
}

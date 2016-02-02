package com.roshankhatri.neccps.model;

import java.util.HashSet;
import java.util.Set;


public class Semester {
	private long id;
	private long semesterYear;
	private String semesterSession;
	private Batch batch;
	private Set<Course> courses=new HashSet<Course>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSemesterYear() {
		return semesterYear;
	}
	public void setSemesterYear(long semesterYear) {
		this.semesterYear = semesterYear;
	}
	public String getSemesterSession() {
		return semesterSession;
	}
	public void setSemesterSession(String semesterSession) {
		this.semesterSession = semesterSession;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public void addCourse(Course courseItem){
		courseItem.setSemester(this);
		courses.add(courseItem);
	}
}

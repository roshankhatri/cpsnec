package com.roshankhatri.neccps.model;

import java.util.Set;

public class Course {
	private long id;
	private String courseName;
	private int courseCredit;
	private Set<Student> students;
	
	public Course() {
	}
	public Course(String courseName, int courseCredit) {
		this.courseName = courseName;
		this.courseCredit = courseCredit;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}

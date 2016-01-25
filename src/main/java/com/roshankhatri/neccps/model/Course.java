package com.roshankhatri.neccps.model;

public class Course {
	private long id;
	private String courseName;
	private int courseCredit;
	private Semester semester;
	
	public Course() {
	}
	public Course(String courseName, int courseCredit, Semester semester) {
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.semester = semester;
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
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	
}

package com.roshankhatri.neccps.model;

import java.util.Date;

public class Thesis {
	private long id;
	private String thesisName;
	private Date thesisYear;
	private String thesisState;
	private Student student;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getThesisName() {
		return thesisName;
	}
	public void setThesisName(String thesisName) {
		this.thesisName = thesisName;
	}
	public Date getThesisYear() {
		return thesisYear;
	}
	public void setThesisYear(Date thesisYear) {
		this.thesisYear = thesisYear;
	}
	public String getThesisState() {
		return thesisState;
	}
	public void setThesisState(String thesisState) {
		this.thesisState = thesisState;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}

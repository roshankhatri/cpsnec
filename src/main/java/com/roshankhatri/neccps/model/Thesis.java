package com.roshankhatri.neccps.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Thesis {
	private long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date thesisYear;
	private String thesisState;
	private Student student;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

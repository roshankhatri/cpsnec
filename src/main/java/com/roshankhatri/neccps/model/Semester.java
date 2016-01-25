package com.roshankhatri.neccps.model;


public class Semester {
	private long id;
	private long semesteYear;
	private String semesterSession;
	private Batch batch;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSemesteYear() {
		return semesteYear;
	}
	public void setSemesteYear(long semesteYear) {
		this.semesteYear = semesteYear;
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
}

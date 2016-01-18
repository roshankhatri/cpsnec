package com.roshankhatri.neccps.model;

import java.util.Date;

public class Thesis {
	private int id;
	private String thesisName;
	private Date thesisYear;
	private String thesisState;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
}

package com.roshankhatri.neccps.model;

import java.util.HashSet;
import java.util.Set;

public class Program {
	private long id;
	private String programName;
	private Set<Batch> batches=new HashSet<Batch>();
	private Set<Course> courses=new HashSet<Course>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public Set<Batch> getBatches() {
		return batches;
	}
	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}
	public void addBatch(Batch batchItem){
		batchItem.setProgram(this);
		batches.add(batchItem);
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}

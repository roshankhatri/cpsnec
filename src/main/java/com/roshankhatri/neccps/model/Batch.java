package com.roshankhatri.neccps.model;

public class Batch {
	private long id;
	private String batchYear;
	private String batchIntake;
	private Program program;
	private Semester semester;
	
	public Batch() {
	}
	
	public Batch(String batchYear, String batchIntake, Program program) {
		super();
		this.batchYear = batchYear;
		this.batchIntake = batchIntake;
		this.program = program;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBatchYear() {
		return batchYear;
	}
	public void setBatchYear(String batchYear) {
		this.batchYear = batchYear;
	}
	public String getBatchIntake() {
		return batchIntake;
	}
	public void setBatchIntake(String batchIntake) {
		this.batchIntake = batchIntake;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}
}

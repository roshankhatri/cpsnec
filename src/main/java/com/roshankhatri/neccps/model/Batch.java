package com.roshankhatri.neccps.model;

import java.util.HashSet;
import java.util.Set;

public class Batch {
	private long id;
	private String batchYear;
	private String batchIntake;
	private Program program;
	private Semester semester;
	private Set<Student> students=new HashSet<Student>();
	
	public Batch() {
	}
	
	public Batch(String batchYear, String batchIntake) {
		super();
		this.batchYear = batchYear;
		this.batchIntake = batchIntake;
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public void addStudent(Student studentItem){
		studentItem.setBatch(this);
		students.add(studentItem);
	}
}

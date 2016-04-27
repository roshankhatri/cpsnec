package com.roshankhatri.neccps.model;

public class Account {
	private long id;
	private Long semesterOne;
	private Long installmentOne;
	private boolean isCompleteOne;
	private Long semseterTwo;
	private Long installmentTwo;
	private boolean isCompleteTwo;
	private Long semesterThree;
	private Long installmentThree;
	private boolean isCompleteThree; 
	private Long semesterFour;
	private Long installmentFour;
	private boolean isCompleteFour;
	private Student student;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getSemesterOne() {
		return semesterOne;
	}
	public void setSemesterOne(Long semesterOne) {
		this.semesterOne = semesterOne;
	}
	public Long getInstallmentOne() {
		return installmentOne;
	}
	public void setInstallmentOne(Long installmentOne) {
		this.installmentOne = installmentOne;
	}
	public boolean isCompleteOne() {
		return isCompleteOne;
	}
	public void setCompleteOne(boolean isCompleteOne) {
		this.isCompleteOne = isCompleteOne;
	}
	public Long getSemseterTwo() {
		return semseterTwo;
	}
	public void setSemseterTwo(Long semseterTwo) {
		this.semseterTwo = semseterTwo;
	}
	public Long getInstallmentTwo() {
		return installmentTwo;
	}
	public void setInstallmentTwo(Long installmentTwo) {
		this.installmentTwo = installmentTwo;
	}
	public boolean isCompleteTwo() {
		return isCompleteTwo;
	}
	public void setCompleteTwo(boolean isCompleteTwo) {
		this.isCompleteTwo = isCompleteTwo;
	}
	public Long getSemesterThree() {
		return semesterThree;
	}
	public void setSemesterThree(Long semesterThree) {
		this.semesterThree = semesterThree;
	}
	public Long getInstallmentThree() {
		return installmentThree;
	}
	public void setInstallmentThree(Long installmentThree) {
		this.installmentThree = installmentThree;
	}
	public boolean isCompleteThree() {
		return isCompleteThree;
	}
	public void setCompleteThree(boolean isCompleteThree) {
		this.isCompleteThree = isCompleteThree;
	}
	public Long getSemesterFour() {
		return semesterFour;
	}
	public void setSemesterFour(Long semesterFour) {
		this.semesterFour = semesterFour;
	}
	public Long getInstallmentFour() {
		return installmentFour;
	}
	public void setInstallmentFour(Long installmentFour) {
		this.installmentFour = installmentFour;
	}
	public boolean isCompleteFour() {
		return isCompleteFour;
	}
	public void setCompleteFour(boolean isCompleteFour) {
		this.isCompleteFour = isCompleteFour;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

}

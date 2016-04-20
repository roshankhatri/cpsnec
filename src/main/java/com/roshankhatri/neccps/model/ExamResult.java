package com.roshankhatri.neccps.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ExamResult {
	private long id;
	private String code;
	private Long credit;
	private Long semseter;
	private String subject;
	private String grade;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enteredDate;
	private Student student;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getSemseter() {
		return semseter;
	}
	public void setSemseter(Long semseter) {
		this.semseter = semseter;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getEnteredDate() {
		return enteredDate;
	}
	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getCredit() {
		return credit;
	}
	public void setCredit(Long credit) {
		this.credit = credit;
	}
}

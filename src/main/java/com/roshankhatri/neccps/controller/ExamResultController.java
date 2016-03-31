package com.roshankhatri.neccps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roshankhatri.neccps.dao.ExamResultDao;
import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.model.ExamResult;
import com.roshankhatri.neccps.model.Student;

public class ExamResultController {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ExamResultDao examResultDao;
	
	@RequestMapping(value={"/","/list"},method=RequestMethod.GET)
	public String listallpayment(Model model){
		List<ExamResult> examResults=examResultDao.listall();
		model.addAttribute("examResults", examResults);
		return "listExamResult";
	}
	@RequestMapping(value="/add/{studentId}", method=RequestMethod.GET)
	public String addpaymentget(Model model,@PathVariable long studentId){
		Student student=studentDao.getById(studentId);
		model.addAttribute("student", student);
		model.addAttribute("examResult", new ExamResult());
		return "newExamResult";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addpaymentpost(@ModelAttribute("examResult") ExamResult examResult,@RequestParam("studentId") long studentId){
		Student student=studentDao.getById(studentId);
		examResult.setStudent(student);
		examResultDao.save(examResult);
		long studentId1=student.getId();
		return "redirect:/ExamResult/view/"+studentId1;		
	}	
	@RequestMapping(value="/view/{studentId}",method=RequestMethod.GET)
	public String listbystudent(Model model,@PathVariable long studentId){
		List<ExamResult> examResults=examResultDao.listbyStudent(studentId);
		model.addAttribute("examResults", examResults);
		return "listExamResult"; 
	}

}

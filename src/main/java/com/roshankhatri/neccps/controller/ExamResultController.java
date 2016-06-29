package com.roshankhatri.neccps.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roshankhatri.neccps.dao.CourseDao;
import com.roshankhatri.neccps.dao.ExamResultDao;
import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.model.Course;
import com.roshankhatri.neccps.model.ExamResult;
import com.roshankhatri.neccps.model.Student;

@Controller
@RequestMapping("/ExamResult")
public class ExamResultController {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ExamResultDao examResultDao;
	
	@Autowired
	private CourseDao courseDao;
	
	@RequestMapping(value={"/","/list"},method=RequestMethod.GET)
	public String listallpayment(Model model){
		//List<ExamResult> examResults=examResultDao.listall();
		//model.addAttribute("examResults", examResults);
		return "examresult/examIntro";
	}
	@RequestMapping(value="/add/{studentId}", method=RequestMethod.GET)
	public String addpaymentget(Model model,@PathVariable long studentId){
		Student student=studentDao.getById(studentId);
		long programId=student.getBatch().getProgram().getId();
		List<ExamResult> examResults=examResultDao.listbyStudent(studentId);
		List<Course> courses=courseDao.findByProgram(programId);
		model.addAttribute("courses", courses);
		model.addAttribute("student", student);
		model.addAttribute("examResults", examResults);
		List<String> grades=new LinkedList<>(Arrays.asList(new String[]{
				"A","A-","B+","B","B-","C+","C","C-","D+","D"
		}));
		model.addAttribute("grades", grades);
		model.addAttribute("examResult", new ExamResult());
		return "examresult/newExamResult";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addpaymentpost(@ModelAttribute("examResult") ExamResult examResult,@RequestParam("studentId") long studentId){
		Student student=studentDao.getById(studentId);
		examResult.setStudent(student);
		Long courseId=Long.parseLong(examResult.getSubject());
		System.out.println(courseId);
		Course course=courseDao.getById(courseId);
		examResult.setSubject(course.getCourseTitle());
		examResult.setCode(course.getCourseCode());
		examResult.setSemseter(course.getSemester());
		examResult.setCredit(course.getCredit());
		examResultDao.save(examResult);
		long studentId1=student.getId();
		return "redirect:/ExamResult/view/"+studentId1;		
	}	
	@RequestMapping(value="/view/{studentId}",method=RequestMethod.GET)
	public String listbystudent(Model model,@PathVariable long studentId){
		List<ExamResult> examResults=examResultDao.listbyStudent(studentId);
		model.addAttribute("examResults", examResults);
		model.addAttribute("student", studentDao.getById(studentId));
		return "examresult/listExamResultByStudent"; 
	}

}

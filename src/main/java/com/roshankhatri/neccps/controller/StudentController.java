package com.roshankhatri.neccps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roshankhatri.neccps.dao.BatchDao;
import com.roshankhatri.neccps.dao.ProgramDao;
import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.model.Batch;
import com.roshankhatri.neccps.model.Program;
import com.roshankhatri.neccps.model.Student;

@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired 
	private ProgramDao programDao; 
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private BatchDao batchDao;
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String addstudent(Model model){
		List<Program> programs=programDao.listall();
		model.addAttribute("programs", programs);
		return "studentsearch";
	}	
	
	@RequestMapping(value = "/add/{batchId}", method = RequestMethod.GET)
	public String studentaddget(Model model,@PathVariable long batchId) {
		Batch batch=batchDao.getById(batchId);
		Student student=new Student();
		student.setBatch(batch);
		model.addAttribute("student",student);
		return "home";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String studentaddpost(@ModelAttribute("student") Student student,@RequestParam("batchId") long batchId) {
		Batch batch=batchDao.getById(batchId);
		student.setBatch(batch);
		studentDao.save(student);
		long batchId1=batch.getId();
		return "redirect:/Student/view/"+batchId1;
	}
	@RequestMapping(value="/view/{batchId}",method=RequestMethod.GET)
	public String studentview(Model model,@PathVariable long batchId){
		List<Student> students=studentDao.getByBatchId(batchId);
		model.addAttribute("students", students);
		return "studentlist";
	}

//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String home1(@ModelAttribute("student") Student student) {
//		System.out.println(student.getFirstname().toString());
//		studentDao.save(student);
//		return "redirect:/Student/list";
//	}

	@RequestMapping(value = {"/","/list"}, method = RequestMethod.GET)
	public String home1(Model model) {
		List<Student> students = studentDao.getall();
		model.addAttribute("students", students);
		return "studentlist";
	}
	
//	@RequestMapping(value = "/saveOnBatch", method = RequestMethod.POST)
//	public String saveStudentOnBatch(@ModelAttribute("student") Student student,@RequestParam("batchId") long batchId) {
//		studentDao.save(student);
//		return "redirect:/Batch/showStudent/"+batchId;
//	}
}

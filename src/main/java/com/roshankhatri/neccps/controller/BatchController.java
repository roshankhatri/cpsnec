package com.roshankhatri.neccps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roshankhatri.neccps.dao.BatchDao;
import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.model.Batch;
import com.roshankhatri.neccps.model.Student;

@Controller
@RequestMapping("/Batch")
public class BatchController {
	
	@Autowired
	private BatchDao batchDao;

	@Autowired
	private StudentDao studentDao;
	
	
	@RequestMapping(value="/batch/{programId}",method=RequestMethod.GET)
	public String getBatchProgram(Model model,@PathVariable long programId){
			List<Batch> batches=batchDao.listall(programId);
			model.addAttribute("batches", batches);
			return "progbatch";
	}

	@RequestMapping(value = "/addStudent/{batchId}", method = RequestMethod.GET)
	public String addStudentGet(Model model, @PathVariable long batchId) {
		model.addAttribute("batch", batchDao.getById(batchId));
		model.addAttribute("program", batchDao.getById(batchId).getProgram()
				.getProgramName());
		Student student = new Student();
		batchDao.getById(batchId).addStudent(student);
		model.addAttribute("student", new Student());
		model.addAttribute("batch", batchDao.getById(batchId));
		return "batch/newStudentOnBatch";
	}

//	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
//	public String addStudentPost(@ModelAttribute("student") Student student,
//			HttpSession session, SessionStatus status) {
//		Batch batch = (Batch) session.getAttribute("batch");
//		long batchId = batch.getId();
//		batch.addStudent(student);
//		batchDao.update(batch);
//		status.setComplete();
//		return "redirect:/Batch/showStudent/" + batchId;
//	}

	@RequestMapping(value = "/showStudent/{batchId}", method = RequestMethod.GET)
	public String showStudents(Model model, @PathVariable long batchId) {
		Batch batch = batchDao.getById(batchId);
		List<Student> students = studentDao.getByBatchId(batch.getId());
		model.addAttribute("program", batch.getProgram().getProgramName());
		model.addAttribute("students", students);
		model.addAttribute("batch", batch);
		return "batch/studentlist";
	}

}

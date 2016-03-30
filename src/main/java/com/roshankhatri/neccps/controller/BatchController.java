package com.roshankhatri.neccps.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roshankhatri.neccps.dao.BatchDao;
import com.roshankhatri.neccps.dao.SemesterDao;
import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.model.Batch;
import com.roshankhatri.neccps.model.Semester;
import com.roshankhatri.neccps.model.Student;

@Controller
@RequestMapping("/Batch")
@SessionAttributes("batch")
public class BatchController {
	
	@Autowired
	private BatchDao batchDao;

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private SemesterDao semesterDao;
	
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

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudentPost(@ModelAttribute("student") Student student,
			HttpSession session, SessionStatus status) {
		Batch batch = (Batch) session.getAttribute("batch");
		long batchId = batch.getId();
		batch.addStudent(student);
		batchDao.update(batch);
		status.setComplete();
		return "redirect:/Batch/showStudent/" + batchId;
	}

	@RequestMapping(value = "/showStudent/{batchId}", method = RequestMethod.GET)
	public String showStudents(Model model, @PathVariable long batchId) {
		Batch batch = batchDao.getById(batchId);
		List<Student> students = studentDao.getByBatchId(batch.getId());
		model.addAttribute("program", batch.getProgram().getProgramName());
		model.addAttribute("students", students);
		model.addAttribute("batch", batch);
		return "batch/studentlist";
	}

	@RequestMapping(value = "/addSemester/{batchId}", method = RequestMethod.GET)
	public String addSemesterGet(Model model, @PathVariable long batchId) {
		model.addAttribute("batch", batchDao.getById(batchId));
		model.addAttribute("program", batchDao.getById(batchId).getProgram()
				.getProgramName());
		Semester semester = new Semester();
		model.addAttribute("semester", semester);
		return "semester/semesternew";
	}
	@RequestMapping(value = "/addSemester", method = RequestMethod.POST)
	public String addStudentPost(@ModelAttribute("semester") Semester semester,
			HttpSession session, SessionStatus status,RedirectAttributes redirectAttributes) {
		Batch batch = (Batch) session.getAttribute("batch");
		batch.addSemester(semester);
		batchDao.update(batch);
		redirectAttributes.addFlashAttribute("batch", batch);
		status.setComplete();
		return "redirect:/Batch/displaySemester";
	}
	@RequestMapping(value="/displaySemester",method=RequestMethod.GET)
	public String displaySemester(Model model,@ModelAttribute("batch") Batch batch){
		model.addAttribute("batch", batch);
		List<Semester> semesters=semesterDao.getByBatchId(batch.getId());
		model.addAttribute("semesters", semesters);
		return "semester/semesterall";
	}

}

package com.roshankhatri.neccps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.model.Student;

@Controller
@RequestMapping("/Student")
public class StudentController {
	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		model.addAttribute("student", new Student());
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home1(@ModelAttribute("student") Student student) {
		System.out.println(student.getFirstname().toString());
		studentDao.save(student);
		return "redirect:/Student/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String home1(Model model) {
		List<Student> students = studentDao.getall();
		model.addAttribute("students", students);
		return "studentlist";
	}

}

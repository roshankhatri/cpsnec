package com.roshankhatri.neccps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.model.Student;

@Controller
public class HomeController {
	
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping("/")
	public String home(){
		
		Student student=new Student();
		student.setFirstname("roshan");
		student.setLastname("khatri");
		studentDao.save(student);
		return "home";
	}
}

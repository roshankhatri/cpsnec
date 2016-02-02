package com.roshankhatri.neccps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roshankhatri.neccps.dao.SemesterDao;
import com.roshankhatri.neccps.model.Course;
import com.roshankhatri.neccps.model.Semester;

@Controller
@RequestMapping("/Course")
public class CourseController {

	@Autowired
	private SemesterDao semesterDao;
	
	@RequestMapping(value="/newCourse/{semesterId}",method=RequestMethod.GET)
	public String newCourse(Model model,@PathVariable long semesterId){
		Semester semester=(Semester) semesterDao.getByBatchId(semesterId);
		Course course=new Course();
		model.addAttribute("course", course);
		model.addAttribute("semester", semester);
		return "course/coursenew";
	}
	
}

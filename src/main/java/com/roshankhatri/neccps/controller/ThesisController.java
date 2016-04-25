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

import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.dao.ThesisDao;
import com.roshankhatri.neccps.model.Student;
import com.roshankhatri.neccps.model.Thesis;

@Controller
@RequestMapping("/Thesis")
public class ThesisController {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ThesisDao thesisDao;
	
	@RequestMapping(value={"/","/list"},method=RequestMethod.GET)
	public String listallpayment(Model model){
		List<Thesis> thesises=thesisDao.listall();
		model.addAttribute("thesises", thesises);
		return "thesis/listThesis";
	}
	
	@RequestMapping(value="/update/{thesisId}",method=RequestMethod.GET)
	public String thesisedit(Model model,@PathVariable long thesisId){
		model.addAttribute("student",thesisDao.getById(thesisId).getStudent());
		model.addAttribute("thesis", thesisDao.getById(thesisId));
		List<String> states=new LinkedList<>(Arrays.asList(new String[]{
				"Initial","Proposal","Proposal Defense","Pre Defense","Final Defense","Submission"
		}));
		model.addAttribute("states", states);
		return "thesis/updateThesis";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String thesiseditpost(@ModelAttribute("thesis") Thesis thesis){
		thesisDao.updateThesis(thesis);
		return "redirect:/Thesis/";
	}
	
	@RequestMapping(value="/add/{studentId}", method=RequestMethod.GET)
	public String addpaymentget(Model model,@PathVariable long studentId){
		Student student=studentDao.getById(studentId);
		try{
		if(student.getThesism().getThesisName()!=null && !student.getThesism().getThesisName().isEmpty()){
			model.addAttribute("student", student);
			List<String> states=new LinkedList<>(Arrays.asList(new String[]{
					"Initial","Proposal","Proposal Defense","Pre Defense","Final Defense","Submission"
			}));
			model.addAttribute("states", states);
			model.addAttribute("thesis", new Thesis());
			return "thesis/newThesis";
		}
		else
		{
			return "thesis/addNameFirst";
		}
		}
		catch(Exception ex){
			System.out.println(ex.getStackTrace());
		}
		return "thesis/addNameFirst";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addpaymentpost(@ModelAttribute("thesis") Thesis thesis, @RequestParam("studentId") long studentId){
		Student student=studentDao.getById(studentId);
		thesis.setStudent(student);
		thesisDao.save(thesis);
		long studentId1=student.getId();
		return "redirect:/Thesis/view/"+studentId1;
	}	
	@RequestMapping(value="/view/{studentId}",method=RequestMethod.GET)
	public String listbystudent(Model model,@PathVariable long studentId){
		List<Thesis> thesises=thesisDao.listbyStudent(studentId);
		Student student=studentDao.getById(studentId);
		model.addAttribute("student", student);
		model.addAttribute("thesises", thesises);
		return "thesis/listThesisByStudent"; 
	}
}


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

import com.roshankhatri.neccps.dao.ProgramDao;
import com.roshankhatri.neccps.model.Batch;
import com.roshankhatri.neccps.model.Program;

@Controller
@RequestMapping("/Program")
@SessionAttributes("program")
public class ProgramController {
	
	@Autowired
	private ProgramDao programDao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Model model){
		model.addAttribute("program", new Program());
		return "program";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String h1(@ModelAttribute("program") Program program){
		System.out.println(program.getProgramName().toString());
		long id=programDao.save(program);
		return "redirect:/Program/list";
	}
	
	@RequestMapping(value="/list")
	public String listall(Model model){
		List<Program> pgms=programDao.listall();
		for (Program program : pgms) {
			System.out.println(program.getProgramName());
		}
		model.addAttribute("programs", pgms);
		return "programall";
		
	}
	
	@RequestMapping(value="/addBatch/{programid}",method=RequestMethod.GET)
	public String addbatch(@PathVariable long programid,Model model){
		model.addAttribute("program",programDao.getById(programid));
		Batch batch=new Batch();
		programDao.getById(programid).addBatch(batch);
		model.addAttribute("batch", new Batch());
		return "batchesadd";
	}
	
	@RequestMapping(value="/addBatch",method=RequestMethod.POST)
	public String tests(@ModelAttribute("batch") Batch batch,HttpSession session){
		
		Program program=(Program)session.getAttribute("program");
		program.addBatch(batch);
		programDao.update(program);
		System.out.println(program.getProgramName().toString());
		return "redirect:/testing";
	}
	
	@RequestMapping("/testing")
	public String test1(){
		return null;
	}
}

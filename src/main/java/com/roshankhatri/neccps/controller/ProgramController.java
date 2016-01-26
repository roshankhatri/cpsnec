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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.roshankhatri.neccps.dao.BatchDao;
import com.roshankhatri.neccps.dao.ProgramDao;
import com.roshankhatri.neccps.model.Batch;
import com.roshankhatri.neccps.model.Program;
import com.roshankhatri.neccps.model.Student;

@Controller
@RequestMapping("/Program")
@SessionAttributes("program")
public class ProgramController {
	
	@Autowired
	private ProgramDao programDao;
	
	@Autowired BatchDao batchDao;
	
	//new program get form	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Model model){
		model.addAttribute("program", new Program());
		return "program";
	}
	
	//new program post form
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String h1(@ModelAttribute("program") Program program){
		programDao.save(program);
		return "redirect:/Program/list";
	}
	
	//all programs list 
	@RequestMapping(value="/list")
	public String listall(Model model){
		List<Program> pgms=programDao.listall();
		model.addAttribute("programs", pgms);
		return "programall";
		
	}
	
	//add batch to program when program id is passed get form
	@RequestMapping(value="/addBatch/{programid}",method=RequestMethod.GET)
	public String addbatch(@PathVariable long programid,Model model){
		model.addAttribute("program",programDao.getById(programid));
		Batch batch=new Batch();
		programDao.getById(programid).addBatch(batch);
		model.addAttribute("program", programDao.getById(programid));
		model.addAttribute("batch", new Batch());
		return "batchesadd";
	}
	
	//add batch to program when program id is passed through session post
	@RequestMapping(value="/addBatch",method=RequestMethod.POST)
	public String tests(@ModelAttribute("batch") Batch batch,HttpSession session){
		
		Program program=(Program)session.getAttribute("program");
		program.addBatch(batch);
		long id=programDao.update(program);
		System.out.println(program.getProgramName().toString());
		return "redirect:/Program/list";
		//return "redirect:/Program/showBatch";
		//return "redirect:/Program/Batch/addStudent/"+id;
	}
	
	//show batches when program id is passed
	@RequestMapping(value="/showBatch/{programId}",method=RequestMethod.GET)
	public String getallabtches(Model model,@PathVariable("programId") long programId){
		List<Batch> batches=batchDao.listall(programId);
		Program program=programDao.getById(programId);
		model.addAttribute("program", program);
		model.addAttribute("batches", batches);
		return "batchesall1";
	}
	
	//show batches when no program id is passed
		@RequestMapping(value="/showBatch",method=RequestMethod.GET)
		public String getallabtcheswithoutprograms(Model model){
			List<Batch> batches=batchDao.listAllWithoutProgram();
			model.addAttribute("batches", batches);
			return "batchesall";
		}
		

	@RequestMapping(value="/Batch/addStudent/{batchId}",method=RequestMethod.GET)
	public String addstudent(Model model,@PathVariable long batchId){
		model.addAttribute("batchId", batchId);
		model.addAttribute("student", new Student());
		return "student";
	}
	@RequestMapping(value="/Batch/addStudent",method=RequestMethod.POST)
	public String addstudent(@ModelAttribute("student") Student student,@RequestParam("batchId") long batchId)
	{
		Batch batch=batchDao.getById(batchId);
		batch.addStudent(student);
		batchDao.save(batch);
		return "redirect:/Student/list";
		
	}
}

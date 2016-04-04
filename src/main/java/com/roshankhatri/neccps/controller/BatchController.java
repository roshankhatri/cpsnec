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
import com.roshankhatri.neccps.model.Batch;
import com.roshankhatri.neccps.model.Program;

@Controller
@RequestMapping("/Batch")
public class BatchController {
	@Autowired
	private ProgramDao programDao;
	
	@Autowired
	private BatchDao batchDao;
	
	@RequestMapping(value="/batch/{programId}",method=RequestMethod.GET)
	public String getBatchProgram(Model model,@PathVariable long programId){
			List<Batch> batches=batchDao.listall(programId);
			model.addAttribute("batches", batches);
			return "progbatch";
	}

	@RequestMapping(value = "/update/{batchId}", method = RequestMethod.GET)
	public String addStudentGet(Model model, @PathVariable long batchId) {
		model.addAttribute("program", batchDao.getById(batchId).getProgram());
		model.addAttribute("batch", batchDao.getById(batchId));
		return "batch/updateBatch";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String showStudents(@ModelAttribute("batch") Batch batch,@RequestParam("programId") long programId) {
		Program program=programDao.getById(programId);
		batch.setProgram(program);
		batchDao.update(batch);
		return "batch/studentlist";
	}
	
	@RequestMapping(value={"/","/list"},method=RequestMethod.GET)
	public String listallbatches(Model model){
		List<Batch> batches=batchDao.listAllWithoutProgram();
		model.addAttribute("batches",batches);
		return "batch/listBatch";
	}
	
	@RequestMapping(value="/add/{programId}",method=RequestMethod.GET)
	public String addnewbatchget(Model model,@PathVariable long programId)
	{	Program program=programDao.getById(programId);
		model.addAttribute("program", program);
		model.addAttribute("batch",new Batch());	
		return "batch/newBatch";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addnewbatchpost(@ModelAttribute("batch") Batch batch,@RequestParam("programId") long programId)
	{	Program program=programDao.getById(programId);
		batch.setProgram(program);
		batchDao.save(batch);
		long programId1=program.getId();
		return "redirect:/Batch/view/"+programId1;
	}
	@RequestMapping(value="/view/{programId}",method=RequestMethod.GET)
	public String listBatchByProgram(Model model,@PathVariable long programId){
		List<Batch> batches=batchDao.listall(programId);
		model.addAttribute("program", programDao.getById(programId));
		model.addAttribute("batches", batches);
		return "batch/listBatchByProgram";
	}
}

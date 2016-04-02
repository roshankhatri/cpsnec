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

import com.roshankhatri.neccps.dao.IssueReturnDao;
import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.model.IssueReturn;
import com.roshankhatri.neccps.model.Student;

@Controller
@RequestMapping("/IssueReturn")
public class IssueReturnController {
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private IssueReturnDao issueReturnDao;
	
	@RequestMapping(value={"/","/list"},method=RequestMethod.GET)
	public String listallissueReturns(Model model){
		List<IssueReturn> issueReturns=issueReturnDao.listall();
		model.addAttribute("issueReturns", issueReturns);
		return "issuereturn/listIssueReturn";
	}
	@RequestMapping(value="/add/{studentId}", method=RequestMethod.GET)
	public String addpaymentget(Model model,@PathVariable long studentId){
		Student student=studentDao.getById(studentId);
		model.addAttribute("student", student);
		List<String> checks=new LinkedList<>(Arrays.asList(new String[]{
				"Issue","Return"
		}));
		model.addAttribute("checks", checks);
		model.addAttribute("issueReturn", new IssueReturn());
		return "issuereturn/newIssueReturn";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addpaymentpost(@ModelAttribute("issueReturn") IssueReturn issueReturn,@RequestParam("studentId") long studentId,@RequestParam("issueReturnStatus") String issueReturnStatus){
		Student student=studentDao.getById(studentId);
		issueReturn.setStudent(student);
		if(issueReturnStatus=="Issue")
			System.out.println("Issue");
		else
			System.out.println("Return");
		issueReturnDao.save(issueReturn);
		long studentId1=student.getId();
		return "redirect:/IssueReturn/view/"+studentId1;		
	}	
	@RequestMapping(value="/view/{studentId}",method=RequestMethod.GET)
	public String listbystudent(Model model,@PathVariable long studentId){
		List<IssueReturn> issueReturns=issueReturnDao.listbyStudent(studentId);
		model.addAttribute("student", studentDao.getById(studentId));
		model.addAttribute("issueReturns", issueReturns);
		return "issuereturn/listIssueReturnByStudent"; 
	}

}

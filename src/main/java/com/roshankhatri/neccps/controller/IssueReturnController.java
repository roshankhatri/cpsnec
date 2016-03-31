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

import com.roshankhatri.neccps.dao.IssueReturnDao;
import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.model.IssueReturn;
import com.roshankhatri.neccps.model.Payment;
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
		return "listIssueReturn";
	}
	@RequestMapping(value="/add/{studentId}", method=RequestMethod.GET)
	public String addpaymentget(Model model,@PathVariable long studentId){
		Student student=studentDao.getById(studentId);
		model.addAttribute("student", student);
		System.out.println(student.getFirstname());
		model.addAttribute("payment", new Payment());
		return "newPayment";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addpaymentpost(@ModelAttribute("payment") Payment payment,@RequestParam("studentId") long studentId){
		Student student=studentDao.getById(studentId);
		payment.setStudent(student);
	//	paymentDao.save(payment);
		long studentId1=student.getId();
		return "redirect:/Payment/view/"+studentId1;		
	}	
	@RequestMapping(value="/view/{studentId}",method=RequestMethod.GET)
	public String listbystudent(Model model,@PathVariable long studentId){
	//	List<Payment> payments=paymentDao.listbyStudent(studentId);
	//	model.addAttribute("payments", payments);
		return "listPayment"; 
	}

}

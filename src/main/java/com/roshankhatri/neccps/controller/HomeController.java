package com.roshankhatri.neccps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roshankhatri.neccps.dao.BatchDao;
import com.roshankhatri.neccps.dao.ExamResultDao;
import com.roshankhatri.neccps.dao.IssueReturnDao;
import com.roshankhatri.neccps.dao.PaymentDao;
import com.roshankhatri.neccps.dao.ProgramDao;
import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.dao.ThesisDao;

@Controller
public class HomeController {
	@Autowired
	private ProgramDao programDao;
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private BatchDao batchDao;
	
	@Autowired 
	private ExamResultDao examResultDao;
	
	@Autowired
	private IssueReturnDao issueReturnDao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired ThesisDao thesisDao;

	@RequestMapping("/")
	public String home() {
		return "main";
	}
	@RequestMapping(value="/Home/stats",method=RequestMethod.GET)
	public String getstats(Model model){
		model.addAttribute("programs", programDao.getCount());
		model.addAttribute("batches", batchDao.getCount());
		model.addAttribute("students", studentDao.getCount());
		model.addAttribute("payments", paymentDao.getCount());
		model.addAttribute("exams", examResultDao.getCount());
		model.addAttribute("irs", issueReturnDao.getCount());
		model.addAttribute("thesis", thesisDao.getCount());
		return "stats";
	}
	@RequestMapping("/403")
	public String testing() {
		System.out.println("403");
		return "403";

	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout=error";
	}
}

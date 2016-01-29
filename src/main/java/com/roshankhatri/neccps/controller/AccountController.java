package com.roshankhatri.neccps.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roshankhatri.neccps.dao.AccountDao;
import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.model.Account;
import com.roshankhatri.neccps.model.AccountPayment;

@Controller
@RequestMapping("/Account")
@SessionAttributes("account")
public class AccountController {
	@Autowired
	private StudentDao studentDao;

	@Autowired
	private AccountDao accountDao;

	private static final Logger logger = LoggerFactory
			.getLogger(AccountController.class);

	@RequestMapping(value = "/newAccount/{studentId}", method = RequestMethod.GET)
	public String newAccountGet(@PathVariable long studentId, Model model) {
		model.addAttribute("student", studentDao.getById(studentId));
		model.addAttribute("account", new Account());
		return "account/newaccount";
	}

	@RequestMapping(value = "/newAccount", method = RequestMethod.POST)
	public String newAccountPost(@ModelAttribute("account") Account account,
			@RequestParam("studentId") long studentId,
			RedirectAttributes redirectAttributes) {
		account.setStudent(studentDao.getById(studentId));
		accountDao.save(account);
		redirectAttributes.addFlashAttribute(account);
		logger.info("account object saved");
		return "redirect:/Account/payFees";
	}

	@RequestMapping(value = "/payFees", method = RequestMethod.GET)
	public String payFeesGet(Model model,
			@ModelAttribute("account") Account account) {
		AccountPayment accountpayment = new AccountPayment();
		model.addAttribute("student", account.getStudent());
		model.addAttribute("accountpayment", accountpayment);
		logger.info("Payemnt Method call");
		return "account/payment";
	}

	@RequestMapping(value = "/payFees", method = RequestMethod.POST)
	public String payFeesPost(
			@ModelAttribute("accountpayment") AccountPayment accountpayment,
			HttpSession session, SessionStatus status) {
		Account account = (Account) session.getAttribute("account");
		accountpayment.setPaidDate(new Date());
		account.addAccountPayment(accountpayment);
		accountDao.update(account);
		logger.info("Payment Saved");
		return null;
	}

}

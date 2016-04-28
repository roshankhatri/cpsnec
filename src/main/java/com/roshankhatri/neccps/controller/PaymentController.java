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

import com.roshankhatri.neccps.dao.PaymentDao;
import com.roshankhatri.neccps.dao.StudentDao;
import com.roshankhatri.neccps.model.Payment;
import com.roshankhatri.neccps.model.Student;

@Controller
@RequestMapping("/Payment")
public class PaymentController {
	@Autowired
	private StudentDao studentDao;

	@Autowired
	private PaymentDao paymentDao;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listallpayment(Model model) {
		List<Payment> payments = paymentDao.listall();
		model.addAttribute("payments", payments);
		return "payment/listPayment";
	}

	@RequestMapping(value = "/add/{studentId}", method = RequestMethod.GET)
	public String addpaymentget(Model model, @PathVariable long studentId) {
		Student student = studentDao.getById(studentId);
		model.addAttribute("student", student);
		model.addAttribute("payment", new Payment());
		return "payment/newPayment";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addpaymentpost(@ModelAttribute("payment") Payment payment,
			@RequestParam("studentId") long studentId) {
		Student student = studentDao.getById(studentId);
		long sem = payment.getSemester();

		if (sem == 1) {
			long amt = student.getAccount().getInstallmentOne();
			long diff = amt - payment.getPaidAmount();

			if (diff > 0) {
				student.getAccount().setInstallmentOne(diff);
			} else {
				student.getAccount().setCompleteOne(true);
			}
			student.getAccount().setInstallmentOne(diff);
			student.setPayableAmount(student.getPayableAmount()-payment.getPaidAmount());

		} else if (sem == 2) {
			
			long amt = student.getAccount().getInstallmentTwo();
			long diff = amt - payment.getPaidAmount();
			
			if (diff > 0) {
				student.getAccount().setInstallmentTwo(diff);
			} else {
				student.getAccount().setCompleteTwo(true);
			}
			student.getAccount().setInstallmentTwo(diff);
			student.setPayableAmount(student.getPayableAmount()-payment.getPaidAmount());
			
		} else if (sem == 3) {
			long amt = student.getAccount().getInstallmentThree();
			long diff = amt - payment.getPaidAmount();
			if (diff > 0) {
				student.getAccount().setInstallmentThree(diff);
			} else {
				student.getAccount().setCompleteThree(true);
				student.getAccount().setInstallmentThree(diff);
			}
			student.getAccount().setInstallmentThree(diff);
			student.setPayableAmount(student.getPayableAmount()-payment.getPaidAmount());

		} else {
			long amt = student.getAccount().getInstallmentFour();
			long diff = amt - payment.getPaidAmount();
			if (diff > 0) {
				student.getAccount().setInstallmentFour(diff);
			} else {
				student.getAccount().setCompleteFour(true);
				student.getAccount().setInstallmentFour(diff);
			}
			student.getAccount().setInstallmentFour(diff);
			student.setPayableAmount(student.getPayableAmount()-payment.getPaidAmount());
		}
		studentDao.update(student);
		payment.setStudent(student);
		paymentDao.save(payment);
		long studentId1 = student.getId();
		return "redirect:/Payment/view/" + studentId1;
	}

	@RequestMapping(value = "/view/{studentId}", method = RequestMethod.GET)
	public String listbystudent(Model model, @PathVariable long studentId) {
		List<Payment> payments = paymentDao.listbyStudent(studentId);
		model.addAttribute("student", studentDao.getById(studentId));
		model.addAttribute("payments", payments);
		return "payment/listPaymentByStudent";
	}

}

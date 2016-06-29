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
		//List<Payment> payments = paymentDao.listall();
		//model.addAttribute("payments", payments);
		return "payment/paymentIntro";
	}

	@RequestMapping(value = "/add/{studentId}", method = RequestMethod.GET)
	public String addpaymentget(Model model, @PathVariable long studentId) {
		Student student = studentDao.getById(studentId);
		model.addAttribute("student", student);
		List<String> semesters=new LinkedList<>(Arrays.asList(new String[]{
				"1","2","3","4"
		}));
		model.addAttribute("semesters", semesters);
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
			if(amt>0){
			long diff = amt - payment.getPaidAmount();
			if (diff >= 0) {
				student.getAccount().setInstallmentOne(diff);
				student.setPayableAmount(student.getPayableAmount()-payment.getPaidAmount());
				studentDao.update(student);
				payment.setStudent(student);
				paymentDao.save(payment);

			} else {
				student.getAccount().setCompleteOne(true);
			}
			}
			else{
				System.out.println("already cleared semester One");
			}

		} else if (sem == 2) {
			
			long amt = student.getAccount().getInstallmentTwo();
			if(amt>0){
			long diff = amt - payment.getPaidAmount();
			
			if (diff >= 0) {
				student.getAccount().setInstallmentTwo(diff);
				student.setPayableAmount(student.getPayableAmount()-payment.getPaidAmount());
				studentDao.update(student);
				payment.setStudent(student);
				paymentDao.save(payment);
			} else {
				student.getAccount().setCompleteTwo(true);
			}
			}else{
				System.out.println("already cleared semester Two");
			}
			
		} else if (sem == 3) {
			long amt = student.getAccount().getInstallmentThree();
			if(amt> 0){
			long diff = amt - payment.getPaidAmount();
			if (diff >= 0) {
				student.getAccount().setInstallmentThree(diff);
				student.setPayableAmount(student.getPayableAmount()-payment.getPaidAmount());
				studentDao.update(student);
				payment.setStudent(student);
				paymentDao.save(payment);
			} else {
				student.getAccount().setCompleteThree(true);
			}
			}else
			{
				System.out.println("already cleared semester Three");
			}

		} else {
			long amt = student.getAccount().getInstallmentFour();
			if(amt>0){
			long diff = amt - payment.getPaidAmount();
			if (diff >= 0) {
				student.getAccount().setInstallmentFour(diff);
				student.setPayableAmount(student.getPayableAmount()-payment.getPaidAmount());
				studentDao.update(student);
				payment.setStudent(student);
				paymentDao.save(payment);

			} else {
				student.getAccount().setCompleteFour(true);
			}
			}
			else{
				System.out.println("already cleared semester Four");
			}
		}
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

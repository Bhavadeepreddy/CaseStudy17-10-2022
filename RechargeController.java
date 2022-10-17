package com.gl.casestudy4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.casestudy4.bean.Bill;
import com.gl.casestudy4.bean.Offer;

@RestController
public class RechargeController {
	
	@Autowired
	private RechargeService service;
	
	@GetMapping(value="/welcomePage")
	 public ModelAndView showWelcomePage() {
		ModelAndView mv = new ModelAndView("welcomePage");
		List<Offer> offerList = service.findAllOffers();
		mv.addObject("offerList",offerList);
		return mv;
	}
	
	@GetMapping("/performRecharge")
	public ModelAndView saveNewBill(@RequestParam("mobileNumber") String mn,
									  @RequestParam("offerId") long oId) {
		long id = service.generateId();
		Bill bill = new Bill();
		bill.setMobileNumber(mn);
		bill.setOfferId(oId);
		bill.setTransactionId(id);
		service.billSave(bill);
		Offer offer = service.findAOffer(oId);
		ModelAndView mv = new ModelAndView("transactionReport");
		mv.addObject("offer",offer);
		mv.addObject("bill",bill);
		return mv;
	}

}

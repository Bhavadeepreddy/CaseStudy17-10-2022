package com.gl.casestudy4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.casestudy4.bean.Bill;
import com.gl.casestudy4.dao.BillRepository;
import com.gl.casestudy4.dao.OfferRepository;

import antlr.collections.List;

@Service
public class RechargeService {
	
	@Autowired
	private OfferRepository repository1;
	@Autowired
	private BillRepository repository2;
	

	public Long generateId() {
		Long val = repository2.findMaxBillId();
		if(val==null)
			val=100001L;
		else
			val=val+1;
		return val;
	}

	public List<Offer> findAllOffers() {
		List<Offer> offerList = repository1.findAll();
		return offerList;
	}

	public Offer findAOffer(Long id) {
		Offer offer = repository1.getById(id);
		return  offer;
	}
	
	public void billSave(Bill bill) {
		repository2.save(bill);
	}

}

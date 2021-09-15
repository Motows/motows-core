package com.research.purchasesales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.purchasesales.dto.PurchaseDTO;
import com.research.purchasesales.iservice.IPurchaseRepository;

@Component
public class PurchaseService {
	@Autowired
	private IPurchaseRepository PurchaseRepository ;
	
	public String AddPurchaseRequest(PurchaseDTO purchaseDTO) {
		return this.PurchaseRepository.AddPurchaseRequest(purchaseDTO);
	}

	public PurchaseDTO getPurchaseRequest(String purchaseid) {
		return this.PurchaseRepository.getPurchaseRequest(purchaseid);
	}

	public String deleteById(String purchaseid) {
		return this.PurchaseRepository.deleteById(purchaseid);
	}

	public String updatePurchaseReq(PurchaseDTO purchaseDTO) {
		return	this.PurchaseRepository.updatePurchaseReq(purchaseDTO);
	}

}

package com.research.purchasesales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.purchasesales.dto.PurchaseDTO;
import com.research.purchasesales.dto.PurchaseLineDTO;
import com.research.purchasesales.dto.PurchaseWithLineDTO;
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

	public String AddPurchaseRequestWithLine(PurchaseWithLineDTO purchaseDTO) {
		// TODO Auto-generated method stub
		return	this.PurchaseRepository.AddPurchaseWithLineRequest(purchaseDTO);
	}
	
	

}

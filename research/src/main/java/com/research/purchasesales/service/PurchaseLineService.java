package com.research.purchasesales.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.purchasesales.dto.PurchaseLineDTO;
import com.research.purchasesales.iservice.IPurchaseLineRepository;


@Component
public class PurchaseLineService {

	private final Logger log = LoggerFactory.getLogger(PurchaseLineService.class);
	
	
	@Autowired
	private IPurchaseLineRepository purchaseLineRepository;
	
	
	
	public String AddPurchaseLine(PurchaseLineDTO purchaseLineDTO) {
		
		return this.purchaseLineRepository.AddPurchaseLine(purchaseLineDTO);
	}

	
	public PurchaseLineDTO getPurchaseLineById(String purchaseLineId) {
		
		return this.purchaseLineRepository.getPurchaseLineById(purchaseLineId);
	}


	public String deletePurchaseLineById(String purchaseLineId) {
	
		return this.purchaseLineRepository.deletePurchaseLineById(purchaseLineId);
	}

	
	public String updatePurchaseLine(PurchaseLineDTO purchaseLineDTO) {
	
		return this.purchaseLineRepository.updatePurchaseLine(purchaseLineDTO);
	}


	

	
}

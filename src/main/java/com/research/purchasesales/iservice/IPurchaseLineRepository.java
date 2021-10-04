package com.research.purchasesales.iservice;

import org.springframework.stereotype.Component;

import com.research.purchasesales.dto.PurchaseLineDTO;
@Component
public interface IPurchaseLineRepository {

	String AddPurchaseLine(PurchaseLineDTO purchaseLineDTO);

	PurchaseLineDTO getPurchaseLineById(String purchaseLineId);

	String deletePurchaseLineById(String purchaseLineId);

	String updatePurchaseLine(PurchaseLineDTO purchaseLineDTO);
	
}

package com.research.purchasesales.iservice;

import com.research.purchasesales.dto.PurchaseDTO;
import com.research.purchasesales.dto.PurchaseWithLineDTO;

public interface IPurchaseRepository {

	String AddPurchaseRequest(PurchaseDTO purchaseDTO);

	PurchaseDTO getPurchaseRequest(String purchaseid);

	String deleteById(String purchaseid);

	String updatePurchaseReq(PurchaseDTO purchaseDTO);

	String AddPurchaseWithLineRequest(PurchaseWithLineDTO purchaseDTO);

}
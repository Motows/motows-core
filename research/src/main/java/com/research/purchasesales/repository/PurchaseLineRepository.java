package com.research.purchasesales.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.purchasesales.dao.PurchaseLineDAO;
import com.research.purchasesales.dto.PurchaseLineDTO;
import com.research.purchasesales.entity.PurchaseLineProjection;
import com.research.purchasesales.iservice.IPurchaseLineRepository;



@Component
public class PurchaseLineRepository implements IPurchaseLineRepository {

	@Autowired
	private PurchaseLineDAO purchaseLineDAO;
	
	@Override
	public String AddPurchaseLine(PurchaseLineDTO purchaseLineDTO) {
		PurchaseLineProjection purchaseLine = new PurchaseLineProjection();
		
		purchaseLine.setPurchaselineno(purchaseLineDTO.getPurchaselineno());
		purchaseLine.setQty(purchaseLineDTO.getQty());
		purchaseLine.setTax(purchaseLineDTO.getTax());
		purchaseLine.setUom(purchaseLineDTO.getUom());
		purchaseLine.setHSN(purchaseLineDTO.getHSN());
		purchaseLine.setItemcode(purchaseLineDTO.getItemcode());
		purchaseLine.setPrice(purchaseLineDTO.getPrice());
		
		purchaseLineDAO.save(purchaseLine);
		
		
		return "Purchase Line Added";
	}

	@Override
	public PurchaseLineDTO getPurchaseLineById(String purchaseLineId) {
		PurchaseLineProjection purchaseLine = purchaseLineDAO.getOne(purchaseLineId);
		
		PurchaseLineDTO purchaseLineDTO = new PurchaseLineDTO();
		
		purchaseLineDTO.setPurcahseLineId(purchaseLine.getPurcahse_Line_Id());
		purchaseLineDTO.setPurchaselineno(purchaseLine.getPurchaselineno());
		purchaseLineDTO.setQty(purchaseLine.getQty());
		purchaseLineDTO.setTax(purchaseLine.getTax());
		purchaseLineDTO.setUom(purchaseLine.getUom());
		purchaseLineDTO.setHSN(purchaseLine.getHSN());
		purchaseLineDTO.setItemcode(purchaseLine.getItemcode());
		purchaseLineDTO.setPrice(purchaseLine.getPrice());
		
		
		
		return purchaseLineDTO;
	}

	@Override
	public String deletePurchaseLineById(String purchaseLineId) {
		purchaseLineDAO.deleteById(purchaseLineId);
		return "Purchase Line Deleted";
	}

	@Override
	public String updatePurchaseLine(PurchaseLineDTO purchaseLineDTO) {
		
		PurchaseLineProjection purchaseLine = purchaseLineDAO.getOne(purchaseLineDTO.getPurcahseLineId());
		
		purchaseLine.setPurchaselineno(purchaseLineDTO.getPurchaselineno());
		purchaseLine.setQty(purchaseLineDTO.getQty());
		purchaseLine.setTax(purchaseLineDTO.getTax());
		purchaseLine.setUom(purchaseLineDTO.getUom());
		purchaseLine.setHSN(purchaseLineDTO.getHSN());
		purchaseLine.setItemcode(purchaseLineDTO.getItemcode());
		purchaseLine.setPrice(purchaseLineDTO.getPrice());
		
		purchaseLineDAO.save(purchaseLine);
		
		
		
		return "Purchase Line Updated";
	}

}

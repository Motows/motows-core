package com.research.purchasesales.repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.finance.dto.ReceiptDTO;
import com.research.finance.entity.ReceiptProjection;
import com.research.purchasesales.dao.PurchaseDAO;
import com.research.purchasesales.dao.PurchaseLineDAO;
import com.research.purchasesales.dto.PurchaseLineDTO;
import com.research.purchasesales.entity.PurchaseLineProjection;
import com.research.purchasesales.entity.PurchaseProjection;
import com.research.purchasesales.iservice.IPurchaseLineRepository;



@Component
public class PurchaseLineRepository implements IPurchaseLineRepository {

	@Autowired
	private PurchaseLineDAO purchaseLineDAO;
	@Autowired
	private PurchaseDAO purchaseDAO;
	
	@Override
	public String AddPurchaseLine(PurchaseLineDTO purchaseLineDTO) {
		PurchaseLineProjection purchaseLine = new PurchaseLineProjection();
		PurchaseProjection purchase = purchaseDAO.getOne(purchaseLineDTO.getPurchaseid());
		if(purchase==null)
		{
			return "Purchase ID "+ purchaseLineDTO.getPurchaseid() +" not in the Master";
		}
		purchaseLine.setPurchaselineno(purchaseLineDTO.getPurchaselineno());
		purchaseLine.setQty(purchaseLineDTO.getQty());
		purchaseLine.setTax(purchaseLineDTO.getTax());
		purchaseLine.setUom(purchaseLineDTO.getUom());
		purchaseLine.setHSN(purchaseLineDTO.getHSN());
		purchaseLine.setItemcode(purchaseLineDTO.getItemcode());
		purchaseLine.setPrice(purchaseLineDTO.getPrice());
		purchaseLine.setPurcahseID(purchaseLineDTO.getPurchaseid());
		
		purchaseLineDAO.save(purchaseLine);
		
		
		return "Purchase Line Added";
	}

	@Override
	public PurchaseLineDTO getPurchaseLineById(String purchaseLineId) {
		PurchaseLineProjection purchaseLine = purchaseLineDAO.getOne(purchaseLineId);
		
		PurchaseLineDTO purchaseLineDTO = new PurchaseLineDTO();
		if(purchaseLine==null)
		{
			purchaseLineDTO.setPurcahseLineId("Invalid ID:"+purchaseLineId);
			return purchaseLineDTO;
		}
		purchaseLineDTO.setPurcahseLineId(purchaseLine.getPurcahse_Line_Id());
		purchaseLineDTO.setPurchaselineno(purchaseLine.getPurchaselineno());
		purchaseLineDTO.setQty(purchaseLine.getQty());
		purchaseLineDTO.setTax(purchaseLine.getTax());
		purchaseLineDTO.setUom(purchaseLine.getUom());
		purchaseLineDTO.setHSN(purchaseLine.getHSN());
		purchaseLineDTO.setItemcode(purchaseLine.getItemcode());
		purchaseLineDTO.setPrice(purchaseLine.getPrice());
		purchaseLineDTO.setPurchaseid(purchaseLine.getPurcahseID());
		
		
		
		return purchaseLineDTO;
	}

	@Override
	public String deletePurchaseLineById(String purchaseLineId) {
		if(purchaseLineDAO.getOne(purchaseLineId)!=null)
		{
			purchaseLineDAO.deleteById(purchaseLineId);
			return "Purchase Line Deleted";
		}
		else
		{
			return "Purchase Line id Not found";
		}

	}

	@Override
	public String updatePurchaseLine(PurchaseLineDTO purchaseLineDTO) {
		
		PurchaseLineProjection purchaseLine = purchaseLineDAO.getOne(purchaseLineDTO.getPurcahseLineId());
		PurchaseProjection purchase = purchaseDAO.getOne(purchaseLineDTO.getPurchaseid());
		if(purchase==null)
		{
			return "Purchase ID "+ purchaseLineDTO.getPurchaseid() +" not in the Master";
		}
		purchaseLine.setPurchaselineno(purchaseLineDTO.getPurchaselineno());
		purchaseLine.setQty(purchaseLineDTO.getQty());
		purchaseLine.setTax(purchaseLineDTO.getTax());
		purchaseLine.setUom(purchaseLineDTO.getUom());
		purchaseLine.setHSN(purchaseLineDTO.getHSN());
		purchaseLine.setItemcode(purchaseLineDTO.getItemcode());
		purchaseLine.setPrice(purchaseLineDTO.getPrice());
		purchaseLine.setPurcahseID(purchaseLineDTO.getPurchaseid());
		purchaseLineDAO.save(purchaseLine);
		
		
		
		return "Purchase Line Updated";
	}


}

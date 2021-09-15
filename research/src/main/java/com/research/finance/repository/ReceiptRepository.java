package com.research.finance.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.finance.dao.ReceiptDAO;
import com.research.finance.dto.ReceiptDTO;
import com.research.finance.entity.ReceiptProjection;
import com.research.finance.iservice.IReceiptRepository;

@Component
public class ReceiptRepository implements IReceiptRepository {

	@Autowired
	private ReceiptDAO receiptDAO;

	@Override
	public String addReceipt(ReceiptDTO receiptDTO) {
		ReceiptProjection receipt = new ReceiptProjection();

		Date now = new Date();

		receipt.setEntry_Type(receiptDTO.getEntryType());
		receipt.setDate(now);
		receipt.setGarage_Id(receiptDTO.getGarageId());
		receipt.setJob_Card_Id(receiptDTO.getJobCardId());
		receipt.setOrganisation_Id(receiptDTO.getOrganisationId());
		receipt.setReceipt_Amount(receiptDTO.getReceiptAmount());
		receipt.setReceipt_Via(receiptDTO.getReceiptVia());

		receiptDAO.save(receipt);
		return "Receipt Saved";
	}

	@Override
	public ReceiptDTO getReceiptById(String receiptId) {
		ReceiptProjection receipt = receiptDAO.getOne(receiptId);

		ReceiptDTO receiptDTO = new ReceiptDTO();

		receiptDTO.setDate(receipt.getDate());
		receiptDTO.setEntryType(receipt.getEntry_Type());
		receiptDTO.setGarageId(receipt.getGarage_Id());
		receiptDTO.setJobCardId(receipt.getJob_Card_Id());
		receiptDTO.setOrganisationId(receipt.getOrganisation_Id());
		receiptDTO.setReceiptAmount(receipt.getReceipt_Amount());
		receiptDTO.setReceiptId(receipt.getReceipt_Id());
		receiptDTO.setReceiptVia(receipt.getReceipt_Via());

		return receiptDTO;
	}

	@Override
	public String deleteReceiptById(String receiptId) {
		receiptDAO.deleteById(receiptId);
		return "Receipt whth Id " + receiptId + " Deleted";
	}

	@Override
	public String UpdateReceipt(ReceiptDTO receiptDTO) {

		ReceiptProjection receipt = receiptDAO.getOne(receiptDTO.getReceiptId());
		
		receipt.setEntry_Type(receiptDTO.getEntryType());
		
		receipt.setGarage_Id(receiptDTO.getGarageId());
		receipt.setJob_Card_Id(receiptDTO.getJobCardId());
		receipt.setOrganisation_Id(receiptDTO.getOrganisationId());
		receipt.setReceipt_Amount(receiptDTO.getReceiptAmount());
		receipt.setReceipt_Via(receiptDTO.getReceiptVia());

		receiptDAO.save(receipt);
		return "Receipt Updated";
	}

}

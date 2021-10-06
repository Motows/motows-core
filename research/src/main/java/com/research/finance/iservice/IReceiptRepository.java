package com.research.finance.iservice;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.research.finance.dto.ReceiptDTO;



@Component

public interface IReceiptRepository {

	String addReceipt(ReceiptDTO receiptDTO);
	ReceiptDTO getReceiptById(String receiptId);
	String deleteReceiptById(String receiptId);
	String UpdateReceipt(ReceiptDTO receiptDTO);
	List<ReceiptDTO> getReceiptList(String organisation_id, String fromdate, String todate) throws ParseException;
	
}

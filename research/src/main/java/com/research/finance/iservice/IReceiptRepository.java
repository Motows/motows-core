package com.research.finance.iservice;

import org.springframework.stereotype.Component;

import com.research.finance.dto.ReceiptDTO;



@Component

public interface IReceiptRepository {

	String addReceipt(ReceiptDTO receiptDTO);
	ReceiptDTO getReceiptById(String receiptId);
	
	 String deleteReceiptById(String receiptId);

	String UpdateReceipt(ReceiptDTO receiptDTO);
	
}

package com.research.finance.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.finance.dto.ReceiptDTO;
import com.research.finance.iservice.IReceiptRepository;

@Component
public class ReceiptService {

	private final Logger log = LoggerFactory.getLogger(ReceiptService.class);
	
	
	@Autowired
	private IReceiptRepository receiptRepository;

	public String addReceipt(ReceiptDTO receiptDTO) {

		return this.receiptRepository.addReceipt(receiptDTO);
	}

	public ReceiptDTO getReceiptById(String receiptId) {

		return this.receiptRepository.getReceiptById(receiptId);
	}

	public String deleteReceiptById(String receiptId) {

		return this.receiptRepository.deleteReceiptById(receiptId);
	}

	public String UpdateReceipt(ReceiptDTO receiptDTO) {

		return this.receiptRepository.UpdateReceipt(receiptDTO);
	}

}

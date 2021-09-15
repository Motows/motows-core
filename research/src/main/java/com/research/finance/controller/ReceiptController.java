package com.research.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.finance.dto.ReceiptDTO;
import com.research.finance.service.ReceiptService;



@RestController
@RequestMapping("api/receipt")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;
	
	@PostMapping
	public String addReceipt(@RequestBody ReceiptDTO receiptDTO) {

		return this.receiptService.addReceipt(receiptDTO);
	}

	@GetMapping("/{receiptId}")
	public ReceiptDTO getReceiptById(@PathVariable String receiptId) {

		return this.receiptService.getReceiptById(receiptId);
	}

	@DeleteMapping("/{receiptId}")
	public String deleteReceiptById(@PathVariable String receiptId) {

		return this.receiptService.deleteReceiptById(receiptId);
	}

	@PutMapping
	public String UpdateReceipt(@RequestBody ReceiptDTO receiptDTO) {

		return this.receiptService.UpdateReceipt(receiptDTO);
	}

	
}

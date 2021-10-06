package com.research.finance.controller;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.finance.service.PaymentService;

import io.swagger.annotations.Api;

import com.research.finance.dto.PaymentDTO;
import com.research.finance.dto.ReceiptDTO;
@RestController
@RequestMapping("api/Payment")
@Api(description = "Payment Controller", tags = { "Finance Payment" })
public class FinancePaymentController {

	@Autowired
	private PaymentService PaymentService;
	
	@PostMapping("/AddPaymenteRequest")
    public String AddPaymenteRequest(@RequestBody PaymentDTO paymentDTO){
    	return this.PaymentService.AddPaymenteRequest(paymentDTO);
    }
	
	@GetMapping("/getAddPaymenteRequest/{paymentid}")
	public PaymentDTO getPaymenteRequest(@PathVariable("paymentid") String paymentid) {
		return this.PaymentService.getAddPaymenteRequest(paymentid);
	}
	@DeleteMapping("/deletePaymenteRequest/{paymentid}")
	public String deletePaymenteRequest(@PathVariable("paymentid") String paymentid) {
		return this.PaymentService.deletePaymenteRequest(paymentid);
	}
	@PutMapping("/UpdatePaymenteRequest")
	public String UpdatePaymenteRequest(@RequestBody PaymentDTO paymentDTO) {
		return this.PaymentService.UpdatePaymenteRequest(paymentDTO);
	}
	@GetMapping("/{organisation_id}/{fromdate}/{todate}")
	public List<PaymentDTO> getPaymentList(@PathVariable String organisation_id,@PathVariable String fromdate,@PathVariable String todate) throws ParseException {

		return this.PaymentService.getPaymentList(organisation_id,fromdate,todate);
	}
	
}
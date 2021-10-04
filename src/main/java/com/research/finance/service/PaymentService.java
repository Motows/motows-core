package com.research.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.finance.dto.PaymentDTO;
import com.research.finance.iservice.IPaymentRepository;


@Component
public class PaymentService {
	@Autowired
	private IPaymentRepository PaymentRepository;
	public String AddPaymenteRequest(PaymentDTO paymentDTO) {
		return this.PaymentRepository.AddPaymenteRequest(paymentDTO);
	}

	public PaymentDTO getAddPaymenteRequest(String paymentid) {
		return this.PaymentRepository.getAddPaymenteRequest(paymentid);
	}

	public String deletePaymenteRequest(String paymentid) {
		return this.PaymentRepository.deletePaymenteRequest(paymentid);
	}

	public String UpdatePaymenteRequest(PaymentDTO paymentDTO) {
		return this.PaymentRepository.UpdatePaymenteRequest(paymentDTO);
	}

}

package com.research.finance.iservice;

import com.research.finance.dto.PaymentDTO;

public interface IPaymentRepository {

	String AddPaymenteRequest(PaymentDTO paymentDTO);

	PaymentDTO getAddPaymenteRequest(String paymentid);

	String deletePaymenteRequest(String paymentid);

	String UpdatePaymenteRequest(PaymentDTO paymentDTO);
	

}

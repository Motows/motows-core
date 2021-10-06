package com.research.finance.iservice;

import java.text.ParseException;
import java.util.List;

import com.research.finance.dto.PaymentDTO;

public interface IPaymentRepository {

	String AddPaymenteRequest(PaymentDTO paymentDTO);

	PaymentDTO getAddPaymenteRequest(String paymentid);

	String deletePaymenteRequest(String paymentid);

	String UpdatePaymenteRequest(PaymentDTO paymentDTO);

	List<PaymentDTO> getPaymentList(String organisation_id, String fromdate, String todate) throws ParseException;
	

}

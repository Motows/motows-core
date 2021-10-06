package com.research.finance.repository;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.finance.dto.PaymentDTO;
import com.research.finance.dto.ReceiptDTO;
import com.research.finance.dao.PaymentDAO;
import com.research.finance.entity.PaymentProjection;
import com.research.finance.entity.ReceiptProjection;
import com.research.finance.iservice.IPaymentRepository;
import com.research.garage.dao.GarageDAO;
import com.research.garage.dao.OrganisationDAO;
import com.research.garage.entity.GarageProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.jobservice.dao.JobCodeDAO;
import com.research.jobservice.entity.JobCardProjection;



@Component
public class PaymentRepository implements IPaymentRepository {
	@Autowired
	private PaymentDAO  PaymentDAO;
	@Autowired
	private JobCodeDAO JobCodeDAO;
	@Autowired
	private GarageDAO garageDAO;

	@Autowired
	private OrganisationDAO organisationDAO;
	@Override
	public String AddPaymenteRequest(PaymentDTO paymentDTO) {
		PaymentProjection paypro = new PaymentProjection();
		
		GarageProjection garagepro = garageDAO.getOne(paymentDTO.getGarageID());
		if(garagepro==null)
		{
			return "Garage ID "+ paymentDTO.getGarageID() +" not in the Master";
		}
		
		
		
		OrganisationProjection org = organisationDAO.getOne(paymentDTO.getOrganisationID());
		
		if(org==null)
		{
			return "Organisation ID "+ paymentDTO.getOrganisationID() +" not in the Master";
		}
		Date now = new Date();
		paypro.setEntrytype(paymentDTO.getEntrytype());
		paypro.setDate(now);
		paypro.setGarageID(paymentDTO.getGarageID());
		paypro.setOrganisationID(paymentDTO.getOrganisationID());
		paypro.setPayment_Amount(paymentDTO.getPayment_Amount());
		paypro.setPayment_Via(paymentDTO.getPaymentVia());
		PaymentDAO.save(paypro);
		return "Payment Request Saved";
	}
	
	@Override
	public PaymentDTO getAddPaymenteRequest(String paymentid) {
		PaymentProjection paypro = PaymentDAO.getOne(paymentid);
		PaymentDTO paydto = new PaymentDTO();
		paydto.setPaymentID(paypro.getPaymentID());
		paydto.setEntrytype(paypro.getEntrytype());
		paydto.setDate(paypro.getDate());
		paydto.setGarageID(paypro.getGarageID());
		paydto.setOrganisationID(paypro.getOrganisationID());
		paydto.setPayment_Amount(paypro.getPayment_Amount());
		paydto.setPaymentVia(paypro.getPayment_Via());
		return paydto;
	}
	
	@Override
	public List<PaymentDTO> getPaymentList(String organisation_id,String fromdate,String todate) throws ParseException {
		List<PaymentDTO> paymentDTOList= new ArrayList<PaymentDTO>();
//		if(fromdate==null ||fromdate=="")
//		{
//			return receiptDTOList; 
//		}
//		
//		if(todate==null ||todate=="")
//		{
//			return receiptDTOList; 
//		}
//			
//		Date fromDate=new SimpleDateFormat("yyyy/MM/dd").parse(fromdate);  
		List<PaymentProjection> receiptList = PaymentDAO.getPaymentList(organisation_id,fromdate,todate);
		
		for(PaymentProjection paypro:receiptList)
		{
			PaymentDTO paydto = new PaymentDTO();
			paydto.setPaymentID(paypro.getPaymentID());
			paydto.setEntrytype(paypro.getEntrytype());
			paydto.setDate(paypro.getDate());
			paydto.setGarageID(paypro.getGarageID());
			paydto.setOrganisationID(paypro.getOrganisationID());
			paydto.setPayment_Amount(paypro.getPayment_Amount());
			paydto.setPaymentVia(paypro.getPayment_Via());
			paymentDTOList.add(paydto);
		}
		return paymentDTOList;
	}

	
	@Override
	public String deletePaymenteRequest(String paymentid) {
		PaymentDAO.deleteById(paymentid);
		
		return "deleted";
	}

	
	@Override
	public String UpdatePaymenteRequest(PaymentDTO paymentDTO) {
		PaymentProjection paypro = PaymentDAO.getOne(paymentDTO.getPaymentID());
		GarageProjection garagepro = garageDAO.getOne(paymentDTO.getGarageID());
		if(garagepro==null)
		{
			return "Garage ID "+ paymentDTO.getGarageID() +" not in the Master";
		}

		OrganisationProjection org = organisationDAO.getOne(paymentDTO.getOrganisationID());
		if(org==null)
		{
			return "Organisation ID "+ paymentDTO.getOrganisationID() +" not in the Master";
		}
		paypro.setPaymentID(paymentDTO.getPaymentID());
		paypro.setEntrytype(paymentDTO.getEntrytype());
		paypro.setDate(paymentDTO.getDate());
		paypro.setGarageID(paymentDTO.getGarageID());
		paypro.setOrganisationID(paymentDTO.getOrganisationID());
		paypro.setPayment_Amount(paymentDTO.getPayment_Amount());
		paypro.setPayment_Via(paymentDTO.getPaymentVia());
		PaymentDAO.save(paypro);
		return "updated";
	}

}

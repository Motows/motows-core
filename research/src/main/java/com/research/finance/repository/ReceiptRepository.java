package com.research.finance.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.finance.dao.ReceiptDAO;
import com.research.finance.dto.ReceiptDTO;
import com.research.finance.entity.ReceiptProjection;
import com.research.finance.iservice.IReceiptRepository;
import com.research.garage.dao.GarageDAO;
import com.research.garage.dao.OrganisationDAO;
import com.research.garage.entity.GarageProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.garage.entity.VendorProjection;
import com.research.jobservice.dao.JobCodeDAO;
import com.research.jobservice.entity.JobCardProjection;
import com.research.vehicle.dao.ModelDAO;
import com.research.vehicle.dao.VINDAO;

@Component
public class ReceiptRepository implements IReceiptRepository {

	@Autowired
	private ReceiptDAO receiptDAO;
	
	@Autowired
	private JobCodeDAO JobCodeDAO;
	
	@Autowired
	private GarageDAO garageDAO;

	
	@Autowired
	private ModelDAO modelDAO;
	
	@Autowired
	private VINDAO vinDAO;

	@Autowired
	private OrganisationDAO organisationDAO;

	@Override
	public String addReceipt(ReceiptDTO receiptDTO) {
		ReceiptProjection receipt = new ReceiptProjection();
		JobCardProjection Jobcard =	JobCodeDAO.getOne(receiptDTO.getJobCardId());
		
		if(Jobcard==null)
		{
			return "Job Code ID "+ receiptDTO.getJobCardId() +" not in the Master";
		}
		GarageProjection garagepro = garageDAO.getOne(receiptDTO.getGarageId());
		if(garagepro==null)
		{
			return "Garage ID "+ receiptDTO.getGarageId() +" not in the Master";
		}
		
		
		
		OrganisationProjection org = organisationDAO.getOne(receiptDTO.getOrganisationId());
		
		if(org==null)
		{
			return "Organisation ID "+ receiptDTO.getOrganisationId() +" not in the Master";
		}
		
		
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
	public List<ReceiptDTO> getReceiptList(String organisation_id,String fromdate,String todate) throws ParseException {
		List<ReceiptDTO> receiptDTOList= new ArrayList<ReceiptDTO>();
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
		List<ReceiptProjection> receiptList = receiptDAO.getReceiptList(organisation_id,fromdate,todate);
		
		for(ReceiptProjection receipt:receiptList)
		{
		ReceiptDTO receiptDTO = new ReceiptDTO();
		receiptDTO.setDate(receipt.getDate());
		receiptDTO.setEntryType(receipt.getEntry_Type());
		receiptDTO.setGarageId(receipt.getGarage_Id());
		receiptDTO.setJobCardId(receipt.getJob_Card_Id());
		receiptDTO.setOrganisationId(receipt.getOrganisation_Id());
		receiptDTO.setReceiptAmount(receipt.getReceipt_Amount());
		receiptDTO.setReceiptId(receipt.getReceipt_Id());
		receiptDTO.setReceiptVia(receipt.getReceipt_Via());
		receiptDTOList.add(receiptDTO);
		}
		return receiptDTOList;
	}

	@Override
	public String deleteReceiptById(String receiptId) {
		receiptDAO.deleteById(receiptId);
		return "Receipt whth Id " + receiptId + " Deleted";
	}

	@Override
	public String UpdateReceipt(ReceiptDTO receiptDTO) {

		ReceiptProjection receipt = receiptDAO.getOne(receiptDTO.getReceiptId());
		
		JobCardProjection Jobcard =	JobCodeDAO.getOne(receiptDTO.getJobCardId());
		
		if(Jobcard==null)
		{
			return "Job Code ID "+ receiptDTO.getJobCardId() +" not in the Master";
		}
		GarageProjection garagepro = garageDAO.getOne(receiptDTO.getGarageId());
		if(garagepro==null)
		{
			return "Garage ID "+ receiptDTO.getGarageId() +" not in the Master";
		}
		
		
		
		OrganisationProjection org = organisationDAO.getOne(receiptDTO.getOrganisationId());
		
		if(org==null)
		{
			return "Organisation ID "+ receiptDTO.getOrganisationId() +" not in the Master";
		}
		
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

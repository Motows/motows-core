package com.research.research.outputadapters.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.CustomerDAO;
import com.research.vehicle.dao.VINDAO;
import com.research.vehicle.dao.VinContactDAO;
import com.research.vehicle.dto.VINDTO;
import com.research.garage.dto.CustomerDTO;
import com.research.garage.dto.VehicelDetailsDTO;
import com.research.garage.entity.CustomerProjection;
import com.research.garage.service.CustomerService;
import com.research.jobservice.dao.JobCodeDAO;
import com.research.jobservice.dao.JobDAO;
import com.research.jobservice.dao.JobItemsDAO;
import com.research.jobservice.dto.JobDTO;
import com.research.jobservice.dto.JobItemsDTO;
import com.research.jobservice.entity.JobCardProjection;
import com.research.jobservice.entity.JobItemsProjection;
import com.research.jobservice.entity.JobProjection;
import com.research.purchasesales.dao.PurchaseDAO;
import com.research.purchasesales.dao.PurchaseLineDAO;
import com.research.purchasesales.dto.PurchaseDTO;
import com.research.purchasesales.dto.PurchaseLineDTO;
import com.research.purchasesales.entity.PurchaseLineProjection;
import com.research.purchasesales.entity.PurchaseProjection;
import com.research.research.applicationservices.spi.IWrapperRepository;
import com.research.research.inputadapters.web.EstimateDTO;
import com.research.research.inputadapters.web.PurchaseDetailsDTO;
import com.research.vehicle.entity.ColorProjection;
import com.research.vehicle.entity.ModelProjection;
import com.research.vehicle.entity.VINProjection;
import com.research.vehicle.entity.VIN_ContactProjection;

@Component
public class WrapperRepository implements IWrapperRepository {

	@Autowired
	private VinContactDAO VinContactDAO;
	
	@Autowired
	private VINDAO VinDAO;
	
	@Autowired
	private JobDAO jobDAO;
	
	@Autowired
	private JobCodeDAO jobCodeDAO;
	
	@Autowired
	private JobItemsDAO jobItemsDAO;
//
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private PurchaseDAO purchaseDAO;
	
	@Autowired
	private PurchaseLineDAO purchaseLineDAO;
//
//	@Autowired
//	EntityManager entityManager;
//	
//	@Autowired
//	private CustomerService customerService;

	@Override
	public List<VehicelDetailsDTO> getVehicleDetails(String mobileNo) {

		List<VehicelDetailsDTO> VehicelDetailsDTOList = new ArrayList<>();

		List<CustomerProjection> customerList = (List<CustomerProjection>) customerDAO.getOneByMobileNo(mobileNo);
		//List<CustomerDTO> customer = customerService.getAllCustomer();
		
		//List<CustomerDTO> fil_customerList = (List<CustomerDTO>) customer.stream().filter(custObj -> mobileNo.equals(custObj.getMobileNo()));

		if (customerList.isEmpty()) {
			return VehicelDetailsDTOList;
		}
		List<VIN_ContactProjection> vinContactList = null; 
		
		for (CustomerProjection customer : customerList) {
			 vinContactList = VinContactDAO.getAllByCustomerId(customer.getCustomer_Id());
		}
//
		if (vinContactList.isEmpty()) {
			return VehicelDetailsDTOList;
//			throw new EntityNotFoundException(
//					"Unable to find " + VIN_ContactProjection.class + "with customerId  " + customer.getCustomerId());
		}
		for (VIN_ContactProjection vinContacts : vinContactList) {
			
			List<VINProjection> vinList=VinDAO.getAllByVehicleId(vinContacts.getVehicleID());
			
			for (VINProjection vin : vinList) {
				VehicelDetailsDTO VehicelDetailsDTO = new VehicelDetailsDTO();
				ColorProjection color=vin.getColor();
				ModelProjection model=vin.getModel();
				VehicelDetailsDTO.setColorDesc(color.getColor_Description());
				VehicelDetailsDTO.setManufactureYear(vin.getManufacture_Year());
				VehicelDetailsDTO.setVehicleNumber(vin.getVINReg_No());
				VehicelDetailsDTO.setModelDesc(model.getModel_Description());
				VehicelDetailsDTOList.add(VehicelDetailsDTO);
				
			}
		}
		
		return VehicelDetailsDTOList;
	}
	
	
	@Override
	public List<VehicelDetailsDTO>  getVehicleByCustomer(String mobileNo,String OrgId) {

		List<VehicelDetailsDTO> VehicelDetailsDTOList = new ArrayList<VehicelDetailsDTO>();

		List<CustomerProjection> customerList = (List<CustomerProjection>) customerDAO.getCustomerListMobID_OrgID(mobileNo,OrgId);
		//List<CustomerDTO> customer = customerService.getAllCustomer();
		
		//List<CustomerDTO> fil_customerList = (List<CustomerDTO>) customer.stream().filter(custObj -> mobileNo.equals(custObj.getMobileNo()));

		if (customerList.isEmpty()) {
			return VehicelDetailsDTOList;
		}
		List<VIN_ContactProjection> vinContactList = null; 
		
		for (CustomerProjection customer : customerList) {
			 vinContactList = VinContactDAO.getAllByCustomerId(customer.getCustomer_Id());
		}
//
		if (vinContactList.isEmpty()) {
			return VehicelDetailsDTOList;
//			throw new EntityNotFoundException(
//					"Unable to find " + VIN_ContactProjection.class + "with customerId  " + customer.getCustomerId());
		}

		for (VIN_ContactProjection vinContacts : vinContactList) {
			
			List<VINProjection> vinList=VinDAO.getAllByVehicleId(vinContacts.getVehicleID());
			
			for (VINProjection vin : vinList) {
				VehicelDetailsDTO VehicelDetailsDTO = new VehicelDetailsDTO();
				ColorProjection color=vin.getColor();
				ModelProjection model=vin.getModel();
				VehicelDetailsDTO.setColorDesc(color.getColor_Description());
				VehicelDetailsDTO.setManufactureYear(vin.getManufacture_Year());
				VehicelDetailsDTO.setVehicleNumber(vin.getVINReg_No());
				VehicelDetailsDTO.setModelDesc(model.getModel_Description());
				VehicelDetailsDTOList.add(VehicelDetailsDTO);
				
			}
		}
		
	
		return VehicelDetailsDTOList;
	}

	
	@Override
	public List<VehicelDetailsDTO>  getVehicleByRegNo(String regNo) {

		List<VehicelDetailsDTO> VehicelDetailsDTOList = new ArrayList<VehicelDetailsDTO>();
		List<VINProjection> vinList = VinDAO.getAllByVinRegNo(regNo);
		for(VINProjection vin: vinList)
		{
			VehicelDetailsDTO VehicelDetailsDTO = new VehicelDetailsDTO();
			ColorProjection color=vin.getColor();
			ModelProjection model=vin.getModel();
			VehicelDetailsDTO.setColorDesc(color.getColor_Description());
			VehicelDetailsDTO.setManufactureYear(vin.getManufacture_Year());
			VehicelDetailsDTO.setVehicleNumber(vin.getVINReg_No());
			VehicelDetailsDTO.setModelDesc(model.getModel_Description());
			VehicelDetailsDTOList.add(VehicelDetailsDTO);
		}
	
		return VehicelDetailsDTOList;
	}
	
	@Override
	public List<VehicelDetailsDTO>  getVehicleByRegNo_old(String OrgId,String regNo) {

		List<VehicelDetailsDTO> VehicelDetailsDTOList = new ArrayList<VehicelDetailsDTO>();
		List<VIN_ContactProjection> vinContactList = null; 
		List<VINProjection> vinListTmp = VinDAO.getAllByVinRegNo(regNo);
		List<String> veh_arr = new ArrayList<String>();
		for(VINProjection vin: vinListTmp)
		{
			
			
			//vinContactList.add(vin.getVinContact());
			//vinContactList = VinContactDAO.getAllByRegNo(vin_contact.ge);
			List<CustomerProjection> customerList = (List<CustomerProjection>) 
					customerDAO.getCustomerListCustID_OrgID(vin.getVinContact().getCustomer_Id(),OrgId);
			if(!customerList.isEmpty())
			{
				veh_arr.add(vin.getVinContact().getVehicleID());
			}
		}
//		List<String> veh_arr = new ArrayList<String>();
//		for (VIN_ContactProjection vinContacts : vinContactList) {
//		List<CustomerProjection> customerList = (List<CustomerProjection>) 
//				customerDAO.getCustomerListCustID_OrgID(vinContacts.getCustomer_Id(),OrgId);
//		if(!customerList.isEmpty())
//		{
//			veh_arr.add(regNo);
//		}
//		}


		if(veh_arr!=null)
		    {
			for(String vehicleId:veh_arr)
			{
				List<VINProjection> vinList=VinDAO.getAllByVehicleId(vehicleId);
				for (VINProjection vin : vinList) {
				VehicelDetailsDTO VehicelDetailsDTO = new VehicelDetailsDTO();
				ColorProjection color=vin.getColor();
				ModelProjection model=vin.getModel();
				VehicelDetailsDTO.setColorDesc(color.getColor_Description());
				VehicelDetailsDTO.setManufactureYear(vin.getManufacture_Year());
				VehicelDetailsDTO.setVehicleNumber(vin.getVINReg_No());
				VehicelDetailsDTO.setModelDesc(model.getModel_Description());
				VehicelDetailsDTOList.add(VehicelDetailsDTO);
					}
		
		    	}
		    }
	
		return VehicelDetailsDTOList;
	}
	
	@Override
	public EstimateDTO getEstimateByJobCardID(String jobCardId) {
	EstimateDTO estimateDTO= new EstimateDTO();
	List<JobProjection> jobList = jobDAO.getList(jobCardId);
	List<JobDTO> jobDtoList = new ArrayList<JobDTO>();
	int total=0;
	int jobCount=0;
	List<JobDTO> voiceDtoList = new ArrayList<JobDTO>();
	int voiceCount=0;
	JobCardProjection jobCard = jobCodeDAO.getOne(jobCardId);
	CustomerProjection customer=customerDAO.getCustomer(jobCard.getCustomerID());
	if(customer!=null)
	{
		CustomerDTO response = new CustomerDTO();
		response.setAddress(customer.getAddress());
		response.setCountryId(customer.getCountry_Id());
		response.setCustomerId(customer.getCustomer_Id());
		response.setCustomerName(customer.getCustomer_Name());
		response.setCustomerNameCaption(customer.getCustomer_Name_Caption());
		response.setCustomerNameUi(customer.getCustomer_Name_Ui());;
		response.setOrganisationId(customer.getOrganisation_Id());
		response.setType(customer.getType());
		response.setEmailId(customer.getEmail_Id());
		response.setMobileNo(customer.getMobile_No());
		response.setStateId(customer.getState_Id());
		response.setZipCodeId(customer.getZip_Code_Id());
		response.setGstIn(customer.getGst_In());
		response.setEmailIdVerified(customer.getEmail_Id_Verified());
		response.setMobileNoVerified(customer.getMobile_No_Verified());
		
		estimateDTO.setCustomer(response);
		
	}
	VINProjection vehicle=VinDAO.getVehicle(jobCard.getVehicle_Reg_No());
	if(vehicle!=null)
	{
		VINDTO response = new VINDTO();
		response.setColorID(vehicle.getColor().getColor_Id());
		response.setManufactureYear(vehicle.getManufacture_Year());
		response.setModelID(vehicle.getModel().getModel_Id());
		response.setVehicleID(vehicle.getVINNo());
		response.setVINRegNo(vehicle.getVINReg_No());
		response.setVehicleNotes(vehicle.getVehicle_Notes());
		response.setContactType(vehicle.getVinContact().getContact_Type());
		response.setVINNo(vehicle.getVINNo());
		response.setCustomerId(vehicle.getVinContact().getCustomer_Id());
		//response.setOrgId(OrgId);
		estimateDTO.setVehicle(response);
		
	}
	for(JobProjection job:jobList)
       {
		JobDTO response = new JobDTO();
		response.setJobID(job.getJobID());
		response.setJobCardID(job.getJobCardID());
		response.setGarageid(job.getGarageid());
		response.setOrganisationID(job.getOrganisationID());
		response.setJob_Description(job.getJob_Description());
		response.setJobStatus(job.getJobStatus());
		response.setPrice(job.getPrice());
		response.setJobtype(job.getJob_type());
		if(job.getJob_type().equals("Job"))
		{
			jobDtoList.add(response);
			jobCount=jobCount+1;
		}
		else
		{
			voiceDtoList.add(response);
			voiceCount=voiceCount+1;
		}
		total=total+job.getPrice();
		
       }
		estimateDTO.setJobCount(jobCount);
		estimateDTO.setJobs(jobDtoList);
		estimateDTO.setVoiceCount(voiceCount);
		estimateDTO.setVoice(voiceDtoList);
			
		List<JobItemsProjection> partsList = jobItemsDAO.getList(jobCardId);
		List<JobItemsDTO> partsDtoList = new ArrayList<JobItemsDTO>();
		int partsCount=0;	
		for(JobItemsProjection parts:partsList)
		     {
				JobItemsDTO response = new JobItemsDTO();
				response.setHsnAndSac(parts.getHsn_Or_Sac());
				response.setItemcode(parts.getItemcode());
				response.setJob_cardid(parts.getJob_cardid());
				response.setJobItemId(parts.getJob_Item_Id());
				response.setJobItemType(parts.getJob_Item_Type());
				response.setJobNo(parts.getJob_No());
				response.setPrice(parts.getPrice());
				response.setQty(parts.getQty());
				response.setTax(parts.getTax());
				response.setUom(parts.getUom());
				response.setItem_status(parts.getItem_status());
				partsDtoList.add(response);
				partsCount=partsCount+1;
				total=total+(parts.getPrice().intValue());
		       }
				estimateDTO.setPartsCount(partsCount);
				estimateDTO.setParts(partsDtoList);	
				estimateDTO.setTotal(total);

		return estimateDTO;
	}


	@Override
	public List<PurchaseDetailsDTO> getPurchaseDetailsList(String organisation_id, String fromdate, String todate) {
		// TODO Auto-generated method stub
		List<PurchaseDetailsDTO> purchaseDetailsDTOList = new ArrayList<PurchaseDetailsDTO>();
		List<PurchaseProjection> purchaseList = purchaseDAO.getPurchaseList(organisation_id,fromdate,todate);
		for(PurchaseProjection purchase:purchaseList)
		{
		PurchaseDetailsDTO purchaseDetailsDTO = new PurchaseDetailsDTO();
		List<PurchaseLineDTO> purchaseLineDTOList= new ArrayList<PurchaseLineDTO>();
		PurchaseDTO response = new PurchaseDTO();
		response.setPurcahseID(purchase.getPurcahseID());
		response.setEntryType(purchase.getEntry_Type());
		response.setOrganisationID(purchase.getOrganisationID());
		response.setVendorID(purchase.getVendorID());
		response.setEntryDate(purchase.getEntry_Date());
		response.setSupplierrefno(purchase.getSupplierrefno());
		response.setSupplierrefPostingDate(purchase.getSupplierref_Posting_Date());
		response.setJobno(purchase.getJobno());
		response.setGarageID(purchase.getGarageID());	
		purchaseDetailsDTO.setPurchase(response);
		List<PurchaseLineProjection> purchaseLineList = purchaseLineDAO.getPurchaseLineList(purchase.getPurcahseID());
		for(PurchaseLineProjection purchaseLine:purchaseLineList)
		{
			PurchaseLineDTO purchaseLineDTO = new PurchaseLineDTO();
			purchaseLineDTO.setPurcahseLineId(purchaseLine.getPurcahse_Line_Id());
			purchaseLineDTO.setPurchaselineno(purchaseLine.getPurchaselineno());
			purchaseLineDTO.setQty(purchaseLine.getQty());
			purchaseLineDTO.setTax(purchaseLine.getTax());
			purchaseLineDTO.setUom(purchaseLine.getUom());
			purchaseLineDTO.setHSN(purchaseLine.getHSN());
			purchaseLineDTO.setItemcode(purchaseLine.getItemcode());
			purchaseLineDTO.setPrice(purchaseLine.getPrice());
			purchaseLineDTO.setPurchaseid(purchaseLine.getPurcahseID());
			purchaseLineDTOList.add(purchaseLineDTO);
		}
		purchaseDetailsDTO.setPurchaseLine(purchaseLineDTOList);
		purchaseDetailsDTOList.add(purchaseDetailsDTO);
	}
		
	return purchaseDetailsDTOList;
	}

}

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
import com.research.garage.dto.CustomerDTO;
import com.research.garage.dto.VehicelDetailsDTO;
import com.research.garage.entity.CustomerProjection;
import com.research.garage.service.CustomerService;
import com.research.research.applicationservices.spi.IWrapperRepository;
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
//
	@Autowired
	private CustomerDAO customerDAO;
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

//		for (VIN_ContactProjection vinContacts : vinContactList) {
//			for (VINProjection vin : vinContacts.getVin()) {
//				VehicelDetailsDTO VehicelDetailsDTO = new VehicelDetailsDTO();
//
//				VehicelDetailsDTO.setManufactureYear(vin.getManufacture_Year());
//			//	VehicelDetailsDTO.setModelDescription(vin.getModel().getModel_Description());
//				VehicelDetailsDTOList.add(VehicelDetailsDTO);
//
//			}
//
//		}

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
	public List<VehicelDetailsDTO>  getVehicleByRegNo(String OrgId,String regNo) {

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


}

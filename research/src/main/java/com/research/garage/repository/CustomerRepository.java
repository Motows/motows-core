package com.research.garage.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.CountryDAO;
import com.research.garage.dao.CustomerDAO;
import com.research.garage.dao.OrganisationDAO;
import com.research.garage.dao.StateDAO;
import com.research.garage.dao.ZipCodeDAO;
import com.research.garage.dto.CustomerDTO;
import com.research.garage.entity.CountryProjection;
import com.research.garage.entity.CustomerProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.garage.entity.StateProjection;
import com.research.garage.entity.ZipCodeProjection;
import com.research.garage.iservice.ICustomerRepository;


@Component
public class CustomerRepository implements ICustomerRepository {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private OrganisationDAO organisationDAO;

	@Autowired
	private CountryDAO countryDAO;

	@Autowired
	private StateDAO stateDAO;

	@Autowired
	private ZipCodeDAO zipCodeDAO;

	@Override
	public String saveCustomer(CustomerDTO customerDTO) {
		CustomerProjection customer = new CustomerProjection();

		OrganisationProjection org = organisationDAO.getOne(customerDTO.getOrganisationId());

		if(customerDTO.getCustomerName()=="" || customerDTO.getCustomerName()==null)
		{
			return "Customer Name Required";
		}
		
		if(org==null)
		{
			return "Organisation ID "+ customerDTO.getOrganisationId() +" not in the Master";
		}
		
		CountryProjection country = countryDAO.getOne(customerDTO.getCountryId());
		if(country==null)
		{
			return "Country ID "+ customerDTO.getCountryId() +" not in the Master";
		}
		StateProjection state = stateDAO.getOne(customerDTO.getStateId());
		if(state==null)
		{
			return "State ID "+ customerDTO.getStateId() +" not in the Master";
		}
		ZipCodeProjection zipCode = zipCodeDAO.getOne(customerDTO.getZipCodeId());
		if(zipCode==null)
		{
			return "ZipCode ID "+ customerDTO.getZipCodeId() +" not in the Master";
		}
		
		List<CustomerProjection> customerList=customerDAO.getCustomerListMobID_OrgID(customerDTO.getMobileNo(),customerDTO.getOrganisationId());
		if(customerList.size()>0)
		{
			return "Customer Detail Already Available";
		}
		
		customer.setCustomer_Name(customerDTO.getCustomerName());
		customer.setCustomer_Name_Caption(customerDTO.getCustomerNameCaption());
		customer.setCustomer_Name_Ui(customerDTO.getCustomerNameUi());
		customer.setEmail_Id(customerDTO.getEmailId());
		customer.setEmail_Id_Verified(customerDTO.getEmailIdVerified());
		customer.setGst_In(customerDTO.getGstIn());
		customer.setMobile_No(customerDTO.getMobileNo());
		customer.setMobile_No_Verified(customerDTO.getMobileNoVerified());
		customer.setAddress(customerDTO.getAddress());
		customer.setType(customerDTO.getType());
		customer.setOrganisation_Id(customerDTO.getOrganisationId());;
		customer.setCountry_Id(customerDTO.getCountryId());;
		customer.setState_Id(customerDTO.getStateId());;
		customer.setZip_Code_Id(customerDTO.getZipCodeId());;
		
		//customer.setOrganisation(org);
		//customer.setCountry(country);
		//customer.setState(state);
		//customer.setZipCode(zipCode);

		customerDAO.save(customer);

		return "Customer Saved";
	}

	@Override
	public CustomerDTO getCustomerByMobileOrCustomerId(String mobile_no_or_customer_id) {

		CustomerProjection customer = customerDAO.getOneByMobileNoOrCustomerId(mobile_no_or_customer_id);
		
		if (customer==null) {
			throw new EntityNotFoundException(
					"Unable to find " + CustomerProjection.class + "with customer Id Or Mobile no  " + mobile_no_or_customer_id);
		}

		CustomerDTO customerDTO = new CustomerDTO();

		customerDTO.setCustomerId(customer.getCustomer_Id());
		customerDTO.setCustomerName(customer.getCustomer_Name());
		customerDTO.setCustomerNameCaption(customer.getCustomer_Name_Caption());
		customerDTO.setCustomerNameUi(customer.getCustomer_Name_Ui());
		customerDTO.setEmailId(customer.getEmail_Id());
		customerDTO.setEmailIdVerified(customer.getEmail_Id_Verified());
		customerDTO.setMobileNo(customer.getMobile_No());
		customerDTO.setMobileNoVerified(customer.getMobile_No_Verified());
		customerDTO.setType(customer.getType());
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setGstIn(customer.getGst_In());
		customerDTO.setCountryId(customer.getCountry_Id());
		customerDTO.setOrganisationId(customer.getOrganisation_Id());
		customerDTO.setStateId(customer.getState_Id());
		customerDTO.setZipCodeId(customer.getZip_Code_Id());

		return customerDTO;
	}

	@Override
	public String deleteCustomerById(String customerId) {
		if(customerDAO.getOne(customerId)!=null)
		{
			
			customerDAO.deleteById(customerId);
			return "Customer Deleted";
		}
		else
		{
			return "Customer id Not found";
		}
		
	}

	@Override
	public String UpdateCustomer(CustomerDTO customerDTO) {
		OrganisationProjection org = organisationDAO.getOne(customerDTO.getOrganisationId());

		if(customerDTO.getCustomerName()=="" || customerDTO.getCustomerName()==null)
		{
			return "Customer Name Required";
		}
		
		if(org==null)
		{
			return "Organisation ID "+ customerDTO.getOrganisationId() +" not in the Master";
		}
		
		CountryProjection country = countryDAO.getOne(customerDTO.getCountryId());
		if(country==null)
		{
			return "Country ID "+ customerDTO.getCountryId() +" not in the Master";
		}
		StateProjection state = stateDAO.getOne(customerDTO.getStateId());
		if(state==null)
		{
			return "State ID "+ customerDTO.getStateId() +" not in the Master";
		}
		ZipCodeProjection zipCode = zipCodeDAO.getOne(customerDTO.getZipCodeId());
		if(zipCode==null)
		{
			return "ZipCode ID "+ customerDTO.getZipCodeId() +" not in the Master";
		}

		CustomerProjection customer = customerDAO.getOne(customerDTO.getCustomerId());
		customer.setCustomer_Name(customerDTO.getCustomerName());
		customer.setCustomer_Name_Caption(customerDTO.getCustomerNameCaption());
		customer.setCustomer_Name_Ui(customerDTO.getCustomerNameUi());
		customer.setEmail_Id(customerDTO.getEmailId());
		customer.setEmail_Id_Verified(customerDTO.getEmailIdVerified());
		customer.setGst_In(customerDTO.getGstIn());
		customer.setMobile_No(customerDTO.getMobileNo());
		customer.setMobile_No_Verified(customerDTO.getMobileNoVerified());
		customer.setAddress(customerDTO.getAddress());
		customer.setType(customerDTO.getType());
		customer.setOrganisation_Id(customerDTO.getOrganisationId());;
		customer.setCountry_Id(customerDTO.getCountryId());;
		customer.setState_Id(customerDTO.getStateId());;
		customer.setZip_Code_Id(customerDTO.getZipCodeId());;

		customerDAO.save(customer);

		return "Customer Updated";
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		List<CustomerProjection> allCustomers = customerDAO.findAll();
		
		List<CustomerDTO> allCustomersDTO = new ArrayList<CustomerDTO>();
		

		for (int i = 0; i < allCustomers.size(); i++) {
			
			CustomerProjection	customer = allCustomers.get(i);
			
			CustomerDTO customerDTO = new CustomerDTO();
			
			
			customerDTO.setCustomerId(customer.getCustomer_Id());
			customerDTO.setCustomerName(customer.getCustomer_Name());
			customerDTO.setCustomerNameCaption(customer.getCustomer_Name_Caption());
			customerDTO.setCustomerNameUi(customer.getCustomer_Name_Ui());
			customerDTO.setEmailId(customer.getEmail_Id());
			customerDTO.setEmailIdVerified(customer.getEmail_Id_Verified());
			customerDTO.setMobileNo(customer.getMobile_No());
			customerDTO.setMobileNoVerified(customer.getMobile_No_Verified());
			customerDTO.setType(customer.getType());
			customerDTO.setAddress(customer.getAddress());
			customerDTO.setGstIn(customer.getGst_In());
			customerDTO.setCountryId(customer.getCountry_Id());
			customerDTO.setOrganisationId(customer.getOrganisation_Id());
			customerDTO.setStateId(customer.getState_Id());
			customerDTO.setZipCodeId(customer.getZip_Code_Id());
			allCustomersDTO.add(customerDTO);
			

		}

		return allCustomersDTO;
	}
	
	

}
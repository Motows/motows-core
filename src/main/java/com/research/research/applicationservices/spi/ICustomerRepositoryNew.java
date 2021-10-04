package com.research.research.applicationservices.spi;

import java.util.List;

import org.springframework.stereotype.Component;

import com.research.garage.dto.CustomerDTO;
import com.research.research.outputadapters.repositories.CustomerNew;

@Component
public interface ICustomerRepositoryNew {

//	String saveCustomer(CustomerDTO customerDTO);
//
//	CustomerDTO getCustomerByMobileOrCustomerId(String mobile_no_or_customer_id);
	
	List<CustomerNew> getAllCustomer();

//	String deleteCustomerById(String customerId);
//
//	String UpdateCustomer(CustomerDTO customerDTO);

}
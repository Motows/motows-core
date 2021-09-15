package com.research.garage.iservice;

import java.util.List;

import org.springframework.stereotype.Component;

import com.research.garage.dto.CustomerDTO;

@Component
public interface ICustomerRepository {

	String saveCustomer(CustomerDTO customerDTO);

	CustomerDTO getCustomerByMobileOrCustomerId(String mobile_no_or_customer_id);
	
	List<CustomerDTO> getAllCustomer();

	String deleteCustomerById(String customerId);

	String UpdateCustomer(CustomerDTO customerDTO);

}
package com.research.garage.iservice;

import org.springframework.stereotype.Component;

import com.research.garage.dto.CustomerOrderDTO;


@Component
public interface ICustomerDetailsRepository {

	CustomerOrderDTO saveCustomerDetails(CustomerOrderDTO customerOrderDTO);
	CustomerOrderDTO getItemsByCustomerId(Long customerId);
	CustomerOrderDTO deleteCustomerById(Long customerId);

	
	CustomerOrderDTO UpdateCustomer(CustomerOrderDTO customerOrderDTO);
	
	
	
}

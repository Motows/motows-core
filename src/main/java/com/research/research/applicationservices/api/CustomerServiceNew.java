package com.research.research.applicationservices.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.CustomerDTO;
import com.research.garage.iservice.ICustomerRepository;

@Component
public class CustomerServiceNew {

	private final Logger log = LoggerFactory.getLogger(CustomerServiceNew.class);
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	public String saveCustomer(CustomerDTO customerDTO) {
		
		return this.customerRepository.saveCustomer(customerDTO);
	}

	public CustomerDTO getCustomerById(String mobile_no_or_customer_id) {
		
		return this.customerRepository.getCustomerByMobileOrCustomerId(mobile_no_or_customer_id);
	}

	public String deleteCustomerById(String customerId) {
	
		return this.customerRepository.deleteCustomerById(customerId);
	}

	public String UpdateCustomer(CustomerDTO customerDTO) {
		
		return this.customerRepository.UpdateCustomer(customerDTO);
	}

	public List<CustomerDTO> getAllCustomer(){
		return this.customerRepository.getAllCustomer();
	}
	
	
	
	
}
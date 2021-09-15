package com.research.garage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.CustomerOrderDTO;
import com.research.garage.iservice.ICustomerDetailsRepository;

@Component
public class CustomerDetailsService {

	private final Logger log = LoggerFactory.getLogger(CustomerDetailsService.class);

	@Autowired
	private ICustomerDetailsRepository customerRepository;

	public CustomerOrderDTO addCustomerDetails(CustomerOrderDTO customerOrderDTO) {

		return this.customerRepository.saveCustomerDetails(customerOrderDTO);

	}

	public CustomerOrderDTO getItemsByCustomerId(Long customerId) {

		return this.customerRepository.getItemsByCustomerId(customerId);

	}
	public CustomerOrderDTO deleteItemsByCustomerId(Long customerId) {
		return this.customerRepository.deleteCustomerById(customerId);
	}

	public CustomerOrderDTO UpdateCustomer(CustomerOrderDTO customerOrderDTO) {
	return	this.customerRepository.UpdateCustomer(customerOrderDTO);
	}
}


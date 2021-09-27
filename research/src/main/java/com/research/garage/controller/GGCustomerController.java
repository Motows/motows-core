package com.research.garage.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.dto.CustomerDTO;
import com.research.garage.service.CustomerService;

import io.swagger.annotations.Api;
@Api(value = "Garage Customer", description = "Customer Controller", tags = { "Garage Customer" })
@RestController
@RequestMapping("api/customer")
public class GGCustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public String saveCustomer(@RequestBody CustomerDTO customerDTO) {

		return this.customerService.saveCustomer(customerDTO);
	}

	@GetMapping("{mobile_no_or_customer_id}")
	public CustomerDTO getCustomerByMobileOrCustomerId(@PathVariable String mobile_no_or_customer_id) {

		return this.customerService.getCustomerById(mobile_no_or_customer_id);
	}

	@DeleteMapping("{customerId}")
	public String deleteCustomerById(@PathVariable String customerId) {

		return this.customerService.deleteCustomerById(customerId);
	}

	@PutMapping
	public String UpdateCustomer(@RequestBody CustomerDTO customerDTO) {

		return this.customerService.UpdateCustomer(customerDTO);
	}
	@GetMapping
	public List<CustomerDTO> getAllCustomer(){
		return this.customerService.getAllCustomer();
	}
	
	

}
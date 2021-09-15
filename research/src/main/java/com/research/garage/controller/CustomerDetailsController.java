package com.research.garage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.dto.CustomerOrderDTO;
import com.research.garage.service.CustomerDetailsService;

@RestController

@RequestMapping("api/customer")
public class CustomerDetailsController {

	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@PostMapping("/addcustomerdetails")
    public CustomerOrderDTO addNewCustomer(@RequestBody CustomerOrderDTO CustomerDetails){
    	return customerDetailsService.addCustomerDetails(CustomerDetails);
    }
	
	@GetMapping("/getItems/{customerId}")
	public CustomerOrderDTO getItemsByCustomerId(@PathVariable("customerId") Long customerId) {
		
		return customerDetailsService.getItemsByCustomerId(customerId);
	}
	@DeleteMapping("/deleteById/{customerId}")
	public CustomerOrderDTO deleteItemsByCustomerId(@PathVariable("customerId") Long customerId) {
		
		return customerDetailsService.deleteItemsByCustomerId(customerId);
	}
	@PostMapping("/updatecustomer")
	public CustomerOrderDTO UpdateCustomer(@RequestBody CustomerOrderDTO customerOrderDTO) {
		return this.customerDetailsService.UpdateCustomer(customerOrderDTO);
	}
	
}

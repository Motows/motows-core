package com.research.research.inputadapters.web;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.research.outputadapters.repositories.Cust_Vin;
import com.research.research.outputadapters.repositories.CustomerNew;
import com.research.research.outputadapters.repositories.CustomerRepositoryNew;
import com.research.research.outputadapters.repositories.ModelNew;
import com.research.research.outputadapters.repositories.VINRepositoryNew;
import com.research.research.outputadapters.repositories.Vin;

@RestController
@RequestMapping("api/customerNew")
public class CustomerControllerNew {
	
	@Autowired
	CustomerRepositoryNew customerrepository;
	
	@Autowired
	VINRepositoryNew vinRepository;
	
	@GetMapping("all")
	public List<CustomerNew> getAllCustomer()
	{
		List<CustomerNew> customer=(List<CustomerNew>) customerrepository.findAll(); 
		return customer;
	}
	
	@GetMapping("getData/{mobile_no}")
	public List<CustomerNew> getAllCustomerData()
	{
		List<CustomerNew> customer=(List<CustomerNew>) customerrepository.findAll(); 
		return customer;
	}
	
	@GetMapping("getDataWithAny/{searchStr}")
	public List<CustomerNew> getAllCustomerDataWithAny(@PathVariable String searchStr)
	{
		List<CustomerNew> customer=(List<CustomerNew>) customerrepository.findAll(); 
		List<CustomerNew> result = customer.stream()                // convert list to stream
	                .filter(obj -> searchStr.equals(obj.getCustomerName()))     // we dont like mkyong
	                .collect(Collectors.toList());
		if(result.isEmpty())
		{
			result = customer.stream()                // convert list to stream
	                .filter(obj -> searchStr.equals(obj.getMobile_no()))     // we dont like mkyong
	                .collect(Collectors.toList());
		}
		if(result.isEmpty())
		{
			List<Vin> vehicle=(List<Vin>) vinRepository.findAll();
			List<Vin> veh_result = vehicle.stream()                // convert list to stream
        .filter(obj -> searchStr.equals(obj.getVin_no()))     // we dont like mkyong
        .collect(Collectors.toList());
			
			for(Vin obj:veh_result)
	    	 {
				result.add(customer.stream().filter(name -> obj.getCustomerID()==name.getId()).findAny().orElse(null));
	    	 }
		}
		return result;
	}
	
	// insert new customer into database
	@PostMapping("add")
	public CustomerNew addCustomer(@RequestBody CustomerNew customer)
	{
		System.out.print("Customer: "+customer);
		return customerrepository.save(customer);
	}
	
	// insert new customer into database
	@PostMapping("addWithVehicle")
	public String addWithVehicle(@RequestBody Cust_Vin cust_vin)
	{
		System.out.print("Customer: "+cust_vin);
		int cust_id= customerrepository.save(cust_vin.getCustomer()).getId();
		if(cust_id!=0)
		{
			cust_vin.getVin().setCustomerID(cust_id);
			vinRepository.save(cust_vin.getVin());
		}
		
		return "Success";
	}
	
	// get particular customer by their ID
	@GetMapping("customer/{id}")
	public Optional<CustomerNew> getCustomerId(@PathVariable int id)
	{
		return customerrepository.findById(id);
	}
	
	@GetMapping("customermobile_no/{mobile_no}")
	public Vin getCustomerphone(@PathVariable(value = "mobile_no") String mobile_no)
	{
		List<CustomerNew> customer=(List<CustomerNew>) customerrepository.findAll(); 
		CustomerNew fil_customer = customer.stream().filter(name -> mobile_no.equals(name.getMobile_no())).findAny().orElse(null);
		Vin fil_Vin=new Vin();
		if(fil_customer!=null)
	    {
	    	int customer_id=fil_customer.getId();
	    	System.out.print("customer_id"+customer_id);
	    	List<Vin> vin=(List<Vin>) vinRepository.findAll();
	    	fil_Vin = vin.stream().filter(name -> customer_id==name.getCustomerID()).findAny().orElse(null);
	    }
	    return fil_Vin;
	}
	
	
	
	// update existing Customer 
	@PutMapping("update/{id}")
	public CustomerNew updateStudent(@RequestBody CustomerNew customer,@PathVariable int id)
	{
		customer.setId(id);
		return customerrepository.save(customer);
	}
	
	// delete particular Customer from database
	
	@DeleteMapping("delete/{id}")
	public void deleteCustomer(@PathVariable int id)
	{
		customerrepository.deleteById(id);
	}

}
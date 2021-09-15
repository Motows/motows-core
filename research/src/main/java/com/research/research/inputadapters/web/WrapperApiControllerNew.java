package com.research.research.inputadapters.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.dto.VehicelDetailsDTO;
import com.research.research.applicationservices.api.WrapperService;
import com.research.research.applicationservices.api.WrapperServiceNew;
import com.research.research.outputadapters.repositories.CategoryNew;
import com.research.research.outputadapters.repositories.CategoryPartsNew;
import com.research.research.outputadapters.repositories.Cust_Vin;
import com.research.research.outputadapters.repositories.CustomerNew;
import com.research.research.outputadapters.repositories.Estimate;
import com.research.research.outputadapters.repositories.EstimateSave;
import com.research.research.outputadapters.repositories.JobNew;
import com.research.research.outputadapters.repositories.PartsNew;
import com.research.research.outputadapters.repositories.Vin;

@RestController
@RequestMapping("api/wrapperapiNew")
public class WrapperApiControllerNew {
	
	@Autowired
	private WrapperServiceNew wrapperService;
	
	@GetMapping("getDataWithAny/{searchStr}")
	public List<CustomerNew> getAllCustomerDataWithAny(@PathVariable String searchStr)
	{
		return this.wrapperService.getAllCustomerDataWithAny(searchStr);
		
	}
	
	@GetMapping("getEstimate/{id}")
	public Estimate getEstimate(@PathVariable(value = "id") int vehicle_id)
	{
		return this.wrapperService.getEstimate(vehicle_id);
		
	}
	
	@GetMapping("getJobList/{model_id}")
	public List<CategoryNew> getJobList(@PathVariable String model_id)
	{
		return this.wrapperService.getJobList(model_id);
		
	}
	
	@GetMapping("getPartList/{make_id}")
	public List<CategoryPartsNew> getPartList(@PathVariable String make_id)
	{
		return this.wrapperService.getPartList(make_id);
		
	}
	
	@PostMapping("addWithVehicle")
	public String addWithVehicle(@RequestBody Cust_Vin cust_vin)
	{
		return this.wrapperService.addWithVehicle(cust_vin);
	}
	
	@PostMapping("addAllEstimate")
	public String addAllEstimate(@RequestBody EstimateSave estimateSave)
	{
		return this.wrapperService.addAllEstimate(estimateSave);
	}
	
	

}

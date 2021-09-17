package com.research.research.inputadapters.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.dto.VehicelDetailsDTO;
import com.research.research.applicationservices.api.WrapperService;
import com.research.research.outputadapters.repositories.VehicelDetailsListDTO;
import com.research.research.outputadapters.repositories.Vin;
import com.research.vehicle.entity.VINProjection;

@RestController
@RequestMapping("api/wrapperapi")
public class WrapperApiController {
	
	@Autowired
	private WrapperService wrapperService;
	
	@GetMapping("/getVehicleDetailsByMobileNo/{mobileNo}")
	public List<VehicelDetailsDTO> getVehicleConDetailsByMobileNo(@PathVariable String mobileNo) {
		return this.wrapperService.getVehicleDetails(mobileNo);

	}
	

	@GetMapping("/getVehicleByCustomer/{mobileNo}/{orgId}")
	public List<VehicelDetailsDTO> getVehicleByCustomer(@PathVariable String mobileNo,@PathVariable String orgId) {
		return this.wrapperService.getVehicleByCustomer(mobileNo,orgId);

	}

	
	@GetMapping("/getVehicleByRegNo/{regNo}")
	public List<VehicelDetailsDTO> getVehicleByRegNo(@PathVariable String regNo) {
		return this.wrapperService.getVehicleByRegNo(regNo);

	}

	
	

}

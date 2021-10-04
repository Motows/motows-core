package com.research.vehicle.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.vehicle.service.VINService;

import io.swagger.annotations.Api;

import com.research.vehicle.dto.VINDTO;
@Api(description = "VIN Controller", tags = { "Vehicle VIN" })

@RestController
@RequestMapping("api/Vin")
public class VHVINController {

	@Autowired
	private VINService VINService;

	
	@PostMapping("/AddVinDetails")
	public String AddVinDetails(@RequestBody VINDTO vindto ) {
		
		return this.VINService.AddVinDetails(vindto);
	}

	@GetMapping("/getvinByID/{VinId}")
	public VINDTO getvinByID(@PathVariable String VinId) {
		
		return this.VINService.getvinByID(VinId);
	}

	@DeleteMapping("/deleteVinByID/{VinId}")
	public String deleteVinByID(@PathVariable String VinId) {
		
		return this.VINService.deleteVinByID(VinId);
	}

	@PostMapping("/updateVinDetails")
	public String updateVinDetails(@RequestBody VINDTO vindto) {
		
		return this.VINService.updateVinDetails(vindto);
	}

	
	
	
}

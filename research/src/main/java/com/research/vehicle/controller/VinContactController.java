package com.research.vehicle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.vehicle.service.VinContactService;
import com.research.vehicle.dto.VinContactDTO;

@RestController
@RequestMapping("api/VinContact")
public class VinContactController {

	@Autowired
	private VinContactService VinContactService;

	@PostMapping("/AddVinConDetails")
	public String AddVehicleConDetails(@RequestBody VinContactDTO vinContactDTO) {

		return this.VinContactService.AddVinConDetails(vinContactDTO);
	}

	@GetMapping("/getvinConByID/{VehicleId}")
	public VinContactDTO getVehicleConByID(@PathVariable String VehicleId) {

		return this.VinContactService.getvinConByID(VehicleId);
	}

	@DeleteMapping("/deleteVinConByID/{VehicleId}")
	public String deleteVehicleConByID(@PathVariable String VehicleId) {

		return this.VinContactService.deleteVinConByID(VehicleId);
	}

	@PutMapping("/updateVinConDetails")
	public String updateVehicleConDetails(@RequestBody VinContactDTO vinContactDTO) {

		return this.VinContactService.updateVinConDetails(vinContactDTO);
	}

	

}

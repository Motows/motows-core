package com.research.garage.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.dto.VendorDTO;
import com.research.garage.service.VendorService;


@RestController
@RequestMapping("api/Vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;

	
	@PostMapping("/AddVendorDetails")
	public String savevendordetails(@RequestBody VendorDTO VendorDTO ) {
		
		return this.vendorService.savevendordetails(VendorDTO);
	}

	@GetMapping("/getVendorByID/{VendorId}")
	public VendorDTO getVendorById(@PathVariable String VendorId) {
		
		return this.vendorService.getVendorById(VendorId);
	}

	@DeleteMapping("/deleteVendorByID/{VendorId}")
	public String deleteVendorByID(@PathVariable String VendorId) {
		
		return this.vendorService.deleteVendorByID(VendorId);
	}

	@PostMapping("/updateVenorDetails")
	public String updateVenorDetails(@RequestBody VendorDTO VendorDTO) {
		
		return this.vendorService.updateVenorDetails(VendorDTO);
	}

	
	
	
}

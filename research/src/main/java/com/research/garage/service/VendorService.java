package com.research.garage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.VendorDTO;
import com.research.garage.iservice.IVendorRepository;

@Component
public class VendorService {

	private final Logger log = LoggerFactory.getLogger(VendorService.class);
	
	@Autowired
	private IVendorRepository VendorRepository;

	public String savevendordetails(VendorDTO vendorDTO) {
		return this.VendorRepository.savevendordetails(vendorDTO);
	}

	public VendorDTO getVendorById(String vendorId) {
		return this.VendorRepository.getVendorById(vendorId);
	}


	public String deleteVendorByID(String vendorId) {
		return this.VendorRepository.deleteVendorByID(vendorId);
	}

	public String updateVenorDetails(VendorDTO vendorDTO) {
		return this.VendorRepository.updateVenorDetails(vendorDTO);
	}

}

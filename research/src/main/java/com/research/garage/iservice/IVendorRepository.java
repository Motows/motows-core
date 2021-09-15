package com.research.garage.iservice;

import org.springframework.stereotype.Component;

import com.research.garage.dto.VendorDTO;

@Component
public interface IVendorRepository {
	
	String savevendordetails(VendorDTO vendorDTO);

	VendorDTO getVendorById(String vendorId);

	String deleteVendorByID(String vendorId);

	String updateVenorDetails(VendorDTO vendorDTO);

}

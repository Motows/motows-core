package com.research.garage.iservice;

import java.util.List;

import org.springframework.stereotype.Component;

import com.research.garage.dto.VendorDTO;

@Component
public interface IVendorRepository {
	
	String savevendordetails(VendorDTO vendorDTO);

	VendorDTO getVendorById(String vendorId);

	String deleteVendorByID(String vendorId);

	String updateVenorDetails(VendorDTO vendorDTO);

	List<VendorDTO> getVendorByOrgID(String orgID);

}

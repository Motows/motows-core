package com.research.vehicle.iservice;

import com.research.vehicle.dto.VinContactDTO;

public interface IVinContactRepository {

	String AddVinConDetails(VinContactDTO vinContactDTO);

	VinContactDTO getvinConByID(String vehicleId);

	String deleteVinConByID(String vehicleId);

	String updateVinConDetails(VinContactDTO vinContactDTO);
	
	

}

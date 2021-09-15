package com.research.research.applicationservices.spi;

import java.util.List;

import com.research.garage.dto.VehicelDetailsDTO;
import com.research.research.outputadapters.repositories.VehicelDetailsListDTO;
import com.research.research.outputadapters.repositories.Vin;
import com.research.vehicle.entity.VINProjection;

public interface IWrapperRepository {

	List<VehicelDetailsDTO> getVehicleDetails(String mobileNo);

	List<VehicelDetailsDTO> getVehicleByCustomer(String mobileNo,String orgId);

	List<VehicelDetailsDTO> getVehicleByRegNo(String orgId,String regNo);

	
	
	
	
	
}

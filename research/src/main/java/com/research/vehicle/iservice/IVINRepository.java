package com.research.vehicle.iservice;

import com.research.vehicle.dto.VINDTO;

public interface IVINRepository {

	String AddVinDetails(VINDTO vindto);

	VINDTO getvinByID(String vinId);

	String deleteVinByID(String vinId);

	String updateVinDetails(VINDTO vindto);
	

}

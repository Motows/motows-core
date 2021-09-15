package com.research.vehicle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.vehicle.dto.VINDTO;
import com.research.vehicle.iservice.IVINRepository;

@Component
public class VINService {
	@Autowired
	private IVINRepository VINRepository;
	public String AddVinDetails(VINDTO vindto) {
		return this.VINRepository.AddVinDetails(vindto);
	}

	public VINDTO getvinByID(String vinId) {
		return this.VINRepository.getvinByID(vinId);
	}

	public String deleteVinByID(String vinId) {
		return this.VINRepository.deleteVinByID(vinId);
	}

	public String updateVinDetails(VINDTO vindto) {
		return this.VINRepository.updateVinDetails(vindto);
	}

}

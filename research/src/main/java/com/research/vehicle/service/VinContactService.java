package com.research.vehicle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.vehicle.dto.VinContactDTO;
import com.research.vehicle.iservice.IVinContactRepository;

@Component
public class VinContactService {
	@Autowired
	private IVinContactRepository VinContactRepository;
	public String AddVinConDetails(VinContactDTO vinContactDTO) {
		return this.VinContactRepository.AddVinConDetails(vinContactDTO);
	}

	public VinContactDTO getvinConByID(String vehicleId) {
		return this.VinContactRepository.getvinConByID(vehicleId);
	}

	public String deleteVinConByID(String vehicleId) {
		return this.VinContactRepository.deleteVinConByID(vehicleId);
	}

	public String updateVinConDetails(VinContactDTO vinContactDTO) {
		return this.VinContactRepository.updateVinConDetails(vinContactDTO);
	}

	
}



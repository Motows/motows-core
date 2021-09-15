package com.research.garage.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.GarageDTO;
import com.research.garage.iservice.IGarageRepository;


@Component
public class GarageService {

	private final Logger log = LoggerFactory.getLogger(GarageService.class);

	@Autowired
	private IGarageRepository garageRepository;

	public String addGarage(GarageDTO garageDTO) {

		return this.garageRepository.savegaragedetail(garageDTO);

	}

	public GarageDTO getItemsByGarageId(String garageId) {

		return this.garageRepository.getItemsByGarageId(garageId);

	}
	public String deleteGarageById(String garageId) {
		return this.garageRepository.deleteGarageById(garageId);
	}

	public String UpdateGarage(GarageDTO garage) {
		// TODO Auto-generated method stub
		return this.garageRepository.UpdateGarage(garage);
	}

	
}
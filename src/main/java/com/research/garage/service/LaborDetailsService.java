package com.research.garage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.LaborDTO;
import com.research.garage.iservice.ILaborRepository;

@Component
public class LaborDetailsService {
	@Autowired
	private ILaborRepository LaborRepository;

	public String addlabordetails(LaborDTO labordto) {
		return this.LaborRepository.savelaborDetails(labordto);
	}

	public LaborDTO getlabordetailsById(String laborId) {
		return this.LaborRepository.getlabordetailsById(laborId);
	}

	public String deleteLaborById(String laborId) {
		return this.LaborRepository.deleteLaborById(laborId);
	}

	public String UpdateLaborDetails(LaborDTO labordto) {
		return	this.LaborRepository.UpdateLaborDetails(labordto);
	}

}

package com.research.vehicle.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.vehicle.dto.ColorDTO;
import com.research.vehicle.iservice.IColorRepository;

@Component
public class ColorService {

	private final Logger log = LoggerFactory.getLogger(ColorService.class);
	
	@Autowired
	private IColorRepository colorRepository; 
	
	public String addColor(ColorDTO colorDTO) {
		return this.colorRepository.addColor(colorDTO);
	}
	public ColorDTO getColorById(String colorId) {
		return this.colorRepository.getColorById(colorId);
	}
	public String deleteColorById(String colorId) {
		return this.colorRepository.deleteColorById(colorId);
	}
	public String updateColor(ColorDTO colorDTO) {
		return this.colorRepository.updateColor(colorDTO);
	}
}

package com.research.vehicle.iservice;

import org.springframework.stereotype.Component;

import com.research.vehicle.dto.ColorDTO;

@Component
public interface IColorRepository {

	String addColor(ColorDTO colorDTO);

	ColorDTO getColorById(String colorId);

	String deleteColorById(String colorId);

	String updateColor(ColorDTO colorDTO);

}

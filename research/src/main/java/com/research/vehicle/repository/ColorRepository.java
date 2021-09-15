package com.research.vehicle.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.vehicle.dto.ColorDTO;
import com.research.vehicle.dao.ColorDAO;
import com.research.vehicle.entity.ColorProjection;
import com.research.vehicle.iservice.IColorRepository;
@Component
public class ColorRepository implements IColorRepository {

	@Autowired
	private ColorDAO colorDAO;
	
	@Override
	public String addColor(ColorDTO colorDTO) {
		ColorProjection color = new ColorProjection();
		color.setColor_Description(colorDTO.getColorDescription());
		colorDAO.save(color);
		
		return "Color Saved";
	}

	@Override
	public ColorDTO getColorById(String colorId) {
		ColorProjection color = colorDAO.getOne(colorId);
		
		ColorDTO colorDTO = new ColorDTO();
		
		colorDTO.setColorDescription(color.getColor_Description());
		colorDTO.setColorId(color.getColor_Id());
		return colorDTO;
	}

	@Override
	public String deleteColorById(String colorId) {
		colorDAO.deleteById(colorId);
		return "color Deleted";
	}

	@Override
	public String updateColor(ColorDTO colorDTO) {
		ColorProjection color = colorDAO.getOne(colorDTO.getColorId());
		color.setColor_Description(colorDTO.getColorDescription());
		colorDAO.save(color);
		return "Color Updated";
	}

}

package com.research.sparecat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dto.MaterialDTO;
import com.research.sparecat.iservice.IMaterialRepository;

@Component
public class MaterialService {
	@Autowired
	private IMaterialRepository materialRepository;
	
	public String addMaterial(MaterialDTO materialDTO) {
		
		return this.materialRepository.addMaterial(materialDTO);
	}

	public MaterialDTO getMaterialById(String partId) {
		
		return this.materialRepository.getMaterialById(partId);
	}

	public String deleteMaterialById(String partId) {
		
		return this.materialRepository.deleteMaterialById(partId);
	}

	public String updateMaterialById(MaterialDTO materialDTO) {
		return this.materialRepository.updateMaterialById(materialDTO);
	}

}

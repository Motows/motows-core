package com.research.sparecat.iservice;

import com.research.sparecat.dto.MaterialDTO;

public interface IMaterialRepository {

	
	MaterialDTO getMaterialById(String partId);

	String addMaterial(MaterialDTO materialDTO);

	String updateMaterialById(MaterialDTO materialDTO);

	String deleteMaterialById(String partId);
	
}

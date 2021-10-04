package com.research.sparecat.iservice;

import java.util.List;

import com.research.jobservice.dto.JobTemplateDTO;
import com.research.sparecat.dto.MaterialDTO;

public interface IMaterialRepository {

	
	MaterialDTO getMaterialById(String partId);

	String addMaterial(MaterialDTO materialDTO);

	String updateMaterialById(MaterialDTO materialDTO);

	String deleteMaterialById(String partId);

	List<MaterialDTO> getPartsdetailsWithCategory(String orgID,String model, String category);
	
}

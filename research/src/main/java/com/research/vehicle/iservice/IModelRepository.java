package com.research.vehicle.iservice;

import java.util.List;

import org.springframework.stereotype.Component;

import com.research.vehicle.dto.BrandDTO;
import com.research.vehicle.dto.ModelDTO;

@Component

public interface IModelRepository {

	String addModel(ModelDTO modelDTO);
	ModelDTO getModelById(String modelId);
	String deleteModelById(String modelId);
	
	String updateModel(ModelDTO modelDTO);
	List<ModelDTO> getAllModel();
}

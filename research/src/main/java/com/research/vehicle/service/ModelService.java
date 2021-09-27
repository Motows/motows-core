package com.research.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.vehicle.dto.BrandDTO;
import com.research.vehicle.dto.ModelDTO;
import com.research.vehicle.iservice.IModelRepository;

@Component
public class ModelService {

//	private final Logger log = LoggerFactory.getLogger(ModelService.class);
	
	@Autowired
	private IModelRepository modelRepository;
	
	public String addModel(ModelDTO modelDTO) {
		
		return this.modelRepository.addModel(modelDTO);
	}
	
	public ModelDTO getModelById(String modelId) {
		return this.modelRepository.getModelById(modelId);
	}
	public String deleteModelById(String modelId) {
		
		return this.modelRepository.deleteModelById(modelId);
	}
	
	public String updateMode(ModelDTO modelDTO) {
		return this.modelRepository.updateModel(modelDTO);
	}

	public List<ModelDTO> getAllModel() {
		// TODO Auto-generated method stub
		return this.modelRepository.getAllModel();
	}
}

package com.research.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.vehicle.service.ModelService;

import io.swagger.annotations.Api;

import com.research.vehicle.dto.BrandDTO;
import com.research.vehicle.dto.ModelDTO;
@Api(description = "Model Controller", tags = { "Vehicle Model" })
@RestController
@RequestMapping("api/model")
public class VHModelController {

	@Autowired
	private ModelService modelService;

	@PostMapping
	public String addModel(@RequestBody ModelDTO modelDTO) {
		return this.modelService.addModel(modelDTO);
	}

	@GetMapping("/{modelId}")
	public ModelDTO getModelById(@PathVariable String modelId) {
		return this.modelService.getModelById(modelId);
	}

	@DeleteMapping("/{modelId}")
	public String deleteModelById(@PathVariable String modelId) {
		return this.modelService.deleteModelById(modelId);
	}

	@PutMapping
	public String updateModel(@RequestBody ModelDTO modelDTO) {
		return this.modelService.updateMode(modelDTO);
	}
	
	@GetMapping("getAllModel")
	public List<ModelDTO> getAllModel() {
		return this.modelService.getAllModel();

	}
}

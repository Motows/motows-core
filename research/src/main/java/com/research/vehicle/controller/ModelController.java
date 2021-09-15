package com.research.vehicle.controller;

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
import com.research.vehicle.dto.ModelDTO;

@RestController
@RequestMapping("api/model")
public class ModelController {

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
}

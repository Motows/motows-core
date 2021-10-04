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

import com.research.vehicle.service.ColorService;

import io.swagger.annotations.Api;

import com.research.vehicle.dto.ColorDTO;
@Api(description = "Color Controller", tags = { "Vehicle Color" })
@RestController
@RequestMapping("api/color")
public class VHColorController {

	@Autowired
	private ColorService colorService;

	@PostMapping
	public String addColor(@RequestBody ColorDTO colorDTO) {
		return this.colorService.addColor(colorDTO);
	}

	@GetMapping("/{colorId}")
	public ColorDTO getColorById(@PathVariable String colorId) {

		return this.colorService.getColorById(colorId);
	}

	@DeleteMapping("/{colorId}")
	public String deleteColorById(@PathVariable String colorId) {

		return this.colorService.deleteColorById(colorId);
	}

	@PutMapping
	public String UpdateColor(@RequestBody ColorDTO colorDTO) {
		return this.colorService.updateColor(colorDTO);
	}

}

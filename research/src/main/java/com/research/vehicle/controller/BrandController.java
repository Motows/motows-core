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

import com.research.vehicle.service.BrandService;
import com.research.vehicle.dto.BrandDTO;

@RestController
@RequestMapping("api/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@PostMapping
	public String addBrand(@RequestBody BrandDTO brandDTO) {
		return this.brandService.addBrand(brandDTO);
	}

	@GetMapping("/{brandId}")
	public BrandDTO getBrandById(@PathVariable String brandId) {
		return this.brandService.getBrandById(brandId);

	}

	@DeleteMapping("/{brandId}")
	public String deleteBrandById(@PathVariable String brandId) {

		return this.brandService.deleteBrandById(brandId);

	}

	@PutMapping
	public String updateBrand(@RequestBody BrandDTO brandDTO) {
		return this.brandService.updateBrand(brandDTO);
	}

}

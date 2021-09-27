package com.research.vehicle.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.vehicle.dto.BrandDTO;
import com.research.vehicle.iservice.IBrandRepository;

@Component
public class BrandService {

	private final  Logger log = LoggerFactory.getLogger(BrandService.class);
	
	@Autowired
	private IBrandRepository brandRepository;
	
	public String addBrand(BrandDTO brandDTO) {
	return	this.brandRepository.addBrand(brandDTO);
	}
	
	public BrandDTO getBrandById(String brandId) {
		return this.brandRepository.getBrandById(brandId);
	}
	
	public String deleteBrandById(String brandId) {
		return this.brandRepository.deleteBrandById(brandId);
		
	}
	public String updateBrand(BrandDTO brandDTO) {
		return this.brandRepository.updateBrand(brandDTO);
	}

	public List<BrandDTO> getAllBrand() {
		// TODO Auto-generated method stub
		return this.brandRepository.getAllBrand();
	}
	
}

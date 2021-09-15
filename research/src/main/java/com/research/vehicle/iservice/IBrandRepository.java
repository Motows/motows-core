package com.research.vehicle.iservice;

import com.research.vehicle.dto.BrandDTO;

public interface IBrandRepository {

	String addBrand(BrandDTO brandDTO);

	BrandDTO getBrandById(String brandId);

	String deleteBrandById(String brandId);

	String updateBrand(BrandDTO brandDTO);

}

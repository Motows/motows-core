package com.research.vehicle.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.vehicle.dto.BrandDTO;
import com.research.vehicle.dao.BrandDAO;
import com.research.vehicle.entity.BrandProjection;
import com.research.vehicle.iservice.IBrandRepository;

@Component
public class BrandRepository implements IBrandRepository {

	@Autowired
	private BrandDAO brandDAO;

	@Override
	public String addBrand(BrandDTO brandDTO) {
		BrandProjection brand = new BrandProjection();

		brand.setBrand_Name(brandDTO.getBrandName());
		brand.setBrand_Caption(brandDTO.getBrandCaption());
		brand.setBrand_Ui(brandDTO.getBrandUi());

		brandDAO.save(brand);
		return "Brand Saved";
	}

	@Override
	public BrandDTO getBrandById(String brandId) {
		BrandProjection brand = brandDAO.getOne(brandId);

		BrandDTO brandDTO = new BrandDTO();

		brandDTO.setBrandCaption(brand.getBrand_Caption());
		brandDTO.setBrandId(brand.getBrand_Id());
		brandDTO.setBrandName(brand.getBrand_Name());
		brandDTO.setBrandUi(brand.getBrand_Ui());

		return brandDTO;
	}

	@Override
	public String deleteBrandById(String brandId) {
		brandDAO.deleteById(brandId);
		return "Brand Deleted";
	}

	@Override
	public String updateBrand(BrandDTO brandDTO) {
		
		BrandProjection brand = brandDAO.getOne(brandDTO.getBrandId());
		
		brand.setBrand_Name(brandDTO.getBrandName());
		brand.setBrand_Caption(brandDTO.getBrandCaption());
		brand.setBrand_Ui(brandDTO.getBrandUi());

		brandDAO.save(brand);
		
		return "Brand Updated";
	}

}

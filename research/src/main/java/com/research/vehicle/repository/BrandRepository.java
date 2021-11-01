package com.research.vehicle.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.vehicle.dto.BrandDTO;
import com.research.vehicle.dto.ModelDTO;
import com.research.vehicle.dao.BrandDAO;
import com.research.vehicle.entity.BrandProjection;
import com.research.vehicle.entity.ModelProjection;
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
		if(brand==null)
		{
			brandDTO.setBrandId("Invalid ID:"+brandId);
			return brandDTO;
		}
		brandDTO.setBrandCaption(brand.getBrand_Caption());
		brandDTO.setBrandId(brand.getBrand_Id());
		brandDTO.setBrandName(brand.getBrand_Name());
		brandDTO.setBrandUi(brand.getBrand_Ui());

		return brandDTO;
	}

	@Override
	public String deleteBrandById(String brandId) {
		if(brandDAO.getOne(brandId)!=null)
		{
			brandDAO.deleteById(brandId);
			return "Brand Deleted";
			}
		else
		{
			return "Brand id Not found";
		}

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

	@Override
	public List<BrandDTO> getAllBrand() {
		// TODO Auto-generated method stub
		List<BrandProjection> brandList = brandDAO.getBrandList();
		List<BrandDTO> brandDTOList = new ArrayList<BrandDTO>();
		for(BrandProjection brand:brandList)
		{
			BrandDTO brandDTO = new BrandDTO();

			brandDTO.setBrandCaption(brand.getBrand_Caption());
			brandDTO.setBrandId(brand.getBrand_Id());
			brandDTO.setBrandName(brand.getBrand_Name());
			brandDTO.setBrandUi(brand.getBrand_Ui());
			brandDTOList.add(brandDTO);
		}
		return brandDTOList;
	}

}

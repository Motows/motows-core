package com.research.garage.iservice;


import java.util.List;

import org.springframework.stereotype.Component;

import com.research.garage.dto.ZipCodeDTO;

@Component
public interface IZipCodeRepository {

	String saveZipCode(ZipCodeDTO ZipCodeDTO);
	ZipCodeDTO getZipCodeById(String ZipCodeId);
	
	 String deleteZipCodeById(String ZipCodeId);

	
	String UpdateZipCode(ZipCodeDTO ZipCodeDTO);
	
	List<ZipCodeDTO> getAllZipCodes();
	
}

package com.research.garage.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.ZipCodeDTO;
import com.research.garage.iservice.IZipCodeRepository;


@Component
public class ZipCodeService {

	private final Logger log = LoggerFactory.getLogger(ZipCodeService.class);
	
	@Autowired
	private IZipCodeRepository ZipCodeRepository;
	
	public String saveZipCode(ZipCodeDTO ZipCodeDTO) {
		
		return this.ZipCodeRepository.saveZipCode(ZipCodeDTO);
	}

	
	public ZipCodeDTO getZipCodeById(String ZipCodeId) {
		
		return this.ZipCodeRepository.getZipCodeById(ZipCodeId);
	}

	
	public String deleteZipCodeById(String ZipCodeId) {
		
		return this.ZipCodeRepository.deleteZipCodeById(ZipCodeId);
	}

	
	public String UpdateZipCode(ZipCodeDTO ZipCodeDTO) {
		
		return this.ZipCodeRepository.UpdateZipCode(ZipCodeDTO);
	}
	public List<ZipCodeDTO> getAllZipCodes(){
		return this.ZipCodeRepository.getAllZipCodes();
	}
}

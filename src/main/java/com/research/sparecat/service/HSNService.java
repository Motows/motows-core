package com.research.sparecat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dto.HSNDTO;
import com.research.sparecat.iservice.IHSNRepository;

@Component
public class HSNService {
	@Autowired
	private IHSNRepository HSNRepository ;

	public String addhsn(HSNDTO hsndto) {
		
		return this.HSNRepository.addhsn(hsndto);	
	}

	public HSNDTO gethsnbyCode(String hsncode) {
		
		return this.HSNRepository.gethsnbyCode(hsncode);
	}

	public String deletehsnbyCode(String hsncode) {
		
		return this.HSNRepository.deletehsnbyCode(hsncode);
	}

	public String updatehsn(HSNDTO hsndto) {
		
		return	this.HSNRepository.updatehsn(hsndto);
	}

}

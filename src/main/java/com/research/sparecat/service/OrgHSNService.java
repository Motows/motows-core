package com.research.sparecat.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dto.OrgHSNDTO;
import com.research.sparecat.iservice.IOrgHSNRepository;
@Component
public class OrgHSNService {
	@Autowired
	private IOrgHSNRepository OrgHSNRepository ;
	public String addorghsn(OrgHSNDTO orghsndto) {
		
		return this.OrgHSNRepository.addorghsn(orghsndto);	
	}

	public OrgHSNDTO gethsnbycode(String hsncode) {
		
		return this.OrgHSNRepository.gethsnbycode(hsncode);
	}

	public String deleteorghsn(String hsncode) {
		
		return this.OrgHSNRepository.deleteorghsn(hsncode);
	}

	public String updatehsn(OrgHSNDTO orghsndto) {
		
		return	this.OrgHSNRepository.updatehsn(orghsndto);
	}

}

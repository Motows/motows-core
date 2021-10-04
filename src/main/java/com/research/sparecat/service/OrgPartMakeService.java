package com.research.sparecat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dto.OrgPartMakeDTO;
import com.research.sparecat.iservice.IOrgPartMakeRepository;

@Component
public class OrgPartMakeService {

	@Autowired
	private IOrgPartMakeRepository orgPartMakeRepository;
	
	public String addOrgPartMake(OrgPartMakeDTO orgPartMakeDTO) {
		return this.orgPartMakeRepository.addOrgPartMake(orgPartMakeDTO);
	}
	
	public OrgPartMakeDTO getOrgPartMake(String orgPartMakeId) {
		return this.orgPartMakeRepository.getOrgPartMake(orgPartMakeId);
	}
	
	public String deleteOrgPartMake(String orgPartMakeId) {
		return this.orgPartMakeRepository.deleteOrgPartMake(orgPartMakeId);
	}
	
	public String updateOrgPartMakeDTO(OrgPartMakeDTO orgPartMakeDTO) {
		return this.orgPartMakeRepository.updateOrgPartMake(orgPartMakeDTO);
	}
}

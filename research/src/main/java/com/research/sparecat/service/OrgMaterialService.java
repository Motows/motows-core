package com.research.sparecat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dto.OrgMaterialDTO;
import com.research.sparecat.iservice.IOrgMaterialRepository;

@Component
public class OrgMaterialService {
	@Autowired
	private IOrgMaterialRepository OrgMaterialRepository;

	public String addorgmaterial(OrgMaterialDTO orgMaterialDTO) {

		return this.OrgMaterialRepository.addorgmaterial(orgMaterialDTO);

	}

	public String deleteorgmatialById(String orgmatId) {

		return this.OrgMaterialRepository.deleteorgmatialById(orgmatId);
	}

	public String updateorgMaterial(OrgMaterialDTO orgMaterialDTO) {
		return this.OrgMaterialRepository.updateorgMaterial(orgMaterialDTO);
	}

	public OrgMaterialDTO getorgmaterialById(String orgmatId) {
		return this.OrgMaterialRepository.getorgmaterialById(orgmatId);
	}

}

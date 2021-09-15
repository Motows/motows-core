package com.research.sparecat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dto.OrgModelDTO;
import com.research.sparecat.iservice.IOrgModelRepository;

@Component
public class OrgModelService {
	@Autowired
	private IOrgModelRepository OrgModelRepository;

	public String addorgmodel(OrgModelDTO orgmodelDTO) {
		return this.OrgModelRepository.addorgmodel(orgmodelDTO);
	}

	public String deleteorgmodelById(String modelId) {

		return this.OrgModelRepository.deleteorgmodelById(modelId);

	}

	public OrgModelDTO getorgmodelById(String modelId) {
		return this.OrgModelRepository.getorgmodelById(modelId);
	}

	public String updateorgModelById(OrgModelDTO orgmodelDTO) {
		return this.OrgModelRepository.updateorgModelById(orgmodelDTO);
	}

}

package com.research.jobservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dto.JobTemplateDTO;
import com.research.jobservice.iservice.IJobTemplateRepository;

@Component
public class JobTemplateService {
	
	@Autowired
	private IJobTemplateRepository JobTemplateRepository;
	public String addjobtemplateDetails(JobTemplateDTO jtdto) {
		return this.JobTemplateRepository.addjobtemplateDetails(jtdto);
	}

	public JobTemplateDTO getjtbyId(String jobtempId) {
	
		return this.JobTemplateRepository.getjtbyId(jobtempId);
	}

	public String deleteJtById(String deleteJtById) {
		
		return this.JobTemplateRepository.deleteJtById(deleteJtById);
	}

	public String updateJTDetails(JobTemplateDTO jtdto) {
		return this.JobTemplateRepository.updateJTDetails(jtdto);
	}

}

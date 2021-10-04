package com.research.jobservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dto.JobDTO;
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
	
	public List<JobTemplateDTO> getjobdetailsWithCategory(String orgId,String modelID,String category) 
	{
		return this.JobTemplateRepository.getjobdetailsWithCategory(orgId,modelID,category);
	}
	
	public List<JobTemplateDTO> getjobdetailsWithDesc(String orgId,String modelID,String desc) 
	{
		return this.JobTemplateRepository.getjobdetailsWithDesc(orgId,modelID,desc);
	}

}

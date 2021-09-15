package com.research.jobservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dto.JobitemTypeDTO;
import com.research.jobservice.iservice.IJobItemTypeRepository;
@Component
public class JobitemTypeService {
	@Autowired
	private IJobItemTypeRepository JobItemTypeRepository ;
	
	public String addjobItemTypedetails(JobitemTypeDTO jobitemTypeDTO) {
		return this.JobItemTypeRepository.addjobItemTypedetails(jobitemTypeDTO);
	}
	public JobitemTypeDTO getjobItemTypedetails(String jobItemTypeId) {
		return this.JobItemTypeRepository.getjobItemTypedetails(jobItemTypeId);
	}
	public String deletejobItemTypeById(String jobItemTypeId) {
		return this.JobItemTypeRepository.deletejobItemTypeById(jobItemTypeId);
	}
	public String updatejobItemTypeDetails(JobitemTypeDTO jobitemTypeDTO) {
		return	this.JobItemTypeRepository.updatejobItemTypeDetails(jobitemTypeDTO);
	}

}
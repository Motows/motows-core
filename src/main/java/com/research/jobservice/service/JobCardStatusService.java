package com.research.jobservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dto.JobCardStatusDTO;
import com.research.jobservice.iservice.IJobCardStatusRepository;

@Component
public class JobCardStatusService {

	Logger log = LoggerFactory.getLogger(JobCardStatusService.class);
	
	@Autowired
	private IJobCardStatusRepository jobCardStatusRepository;
	
	public String addJobCardStatus(JobCardStatusDTO jobCardStatusDTO) {
		return this.jobCardStatusRepository.addJobCardStatus(jobCardStatusDTO);
	}
	
	public JobCardStatusDTO getJobCardStatusById(String jobCardStatusId) {
		return this.jobCardStatusRepository.getJobCardStatusById(jobCardStatusId);
	}
	
	public String deleteJobCardStatusById( String jobCardStatusId) {
		return this.jobCardStatusRepository.deleteJobCardStatusById(jobCardStatusId);
	}
	
	public String UpdateJobCardStatus(JobCardStatusDTO jobCardStatusDTO) {
		return this.jobCardStatusRepository.updateJobCardStatus(jobCardStatusDTO);
	}
}

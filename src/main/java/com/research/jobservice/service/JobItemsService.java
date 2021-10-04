package com.research.jobservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dto.JobItemsDTO;
import com.research.jobservice.iservice.IJobItemsRepository;

@Component
public class JobItemsService {

	private final Logger log = LoggerFactory.getLogger(JobItemsService.class);

	@Autowired
	private IJobItemsRepository jobItemsRepository;

	public String addJobItems(JobItemsDTO jobItemsDTO) {

		return this.jobItemsRepository.saveJobItems(jobItemsDTO);

	}

	public JobItemsDTO getJobItemsById(String jobItemsId) {

		return this.jobItemsRepository.getJobItemsById(jobItemsId);
	}

	public String DeleteJobItemsById(String jobItemsId) {

		return this.jobItemsRepository.deleteJobItemsById(jobItemsId);
	}

	public String updateJobItesm(JobItemsDTO jobItemsDTO) {
		return this.jobItemsRepository.updateJobItems(jobItemsDTO);
	}
}

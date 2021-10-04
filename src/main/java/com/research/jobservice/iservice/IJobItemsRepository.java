package com.research.jobservice.iservice;

import com.research.jobservice.dto.JobItemsDTO;

public interface IJobItemsRepository {

	String saveJobItems(JobItemsDTO jobItemsDTO);

	JobItemsDTO getJobItemsById(String jobItemsId);

	String deleteJobItemsById(String jobItemsId);

	String updateJobItems(JobItemsDTO jobItems);
}

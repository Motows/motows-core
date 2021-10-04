package com.research.jobservice.iservice;

import com.research.jobservice.dto.JobCardStatusDTO;

public interface IJobCardStatusRepository {

	String addJobCardStatus(JobCardStatusDTO jobCardStatusDTO);

	JobCardStatusDTO getJobCardStatusById(String jobCardStatusId);

	String deleteJobCardStatusById(String jobCardStatusId);
	
	String updateJobCardStatus(JobCardStatusDTO jobCardStatusDTO);
}

package com.research.garage.iservice;

import com.research.jobservice.dto.JobDTO;

public interface IJobRepository {
	String saveDetails(JobDTO jobdto) ;

	 JobDTO getJobdetailsById(String jobId);

	 String deletejobById(String jobId) ;

	String UpdateJobDetails(JobDTO jobdto);

	// String UpdateJobDetails(JobDTO jobdto);

}

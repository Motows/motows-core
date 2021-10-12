package com.research.jobservice.iservice;

import com.research.jobservice.dto.JobCodeDTO;
import com.research.jobservice.dto.JobCode_JobDTO;

public interface IJobCodeRepositry {

	String saveDetails(JobCodeDTO jobcodeto);

	JobCodeDTO getjobCodedetails(String jobcodeId);

	

	String UpdateJobDetails(JobCodeDTO jobcodeto);

	String deletejobCodeById(String jobcodeId);

	String saveDetailsWithJob(JobCode_JobDTO jobcodeto);
	

}

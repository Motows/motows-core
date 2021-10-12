package com.research.jobservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dto.JobCodeDTO;
import com.research.jobservice.dto.JobCode_JobDTO;
import com.research.jobservice.iservice.IJobCodeRepositry;

@Component
public class JobCodeService {
	@Autowired
	private IJobCodeRepositry JobCodeRepositry ;
	public String addjobCoded(JobCodeDTO jobcodeto) {
		return this.JobCodeRepositry.saveDetails(jobcodeto);	
	}

	public JobCodeDTO getjobCodedetails(String jobcodeId) {
		return this.JobCodeRepositry.getjobCodedetails(jobcodeId);
	}

	public String deletejobCodeById(String jobcodeId) {
		return this.JobCodeRepositry.deletejobCodeById(jobcodeId);
	}

	public String updatejobCodedetails(JobCodeDTO jobcodeto) {
		return	this.JobCodeRepositry.UpdateJobDetails(jobcodeto);
	}

	public String addjobCodedWithJob(JobCode_JobDTO jobCode_JobDTO) {
		return this.JobCodeRepositry.saveDetailsWithJob(jobCode_JobDTO);
	}

	
}

package com.research.jobservice.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.iservice.IJobRepository;
import com.research.jobservice.dto.JobDTO;


@Component
public class JobService {
	
	@Autowired
	private IJobRepository JobRepository ;
	

	public String addJobdetails(JobDTO jobdto) {
		// TODO Auto-generated method stub
		return this.JobRepository.saveDetails(jobdto);	
		}
	
	public JobDTO getJobdetailsById(String jobId) {
		// TODO Auto-generated method stub
		return this.JobRepository.getJobdetailsById(jobId);
	}
	
	public List<JobDTO> getjobdetailsByJobCardID(String jobCardId) {
		// TODO Auto-generated method stub
		return this.JobRepository.getjobdetailsByJobCardID(jobCardId);
	}
	
	

	public String deletejobById(String jobId) {
		// TODO Auto-generated method stub
		return this.JobRepository.deletejobById(jobId);
	}

	public String UpdateJobDetails(JobDTO jobdto) {
		// TODO Auto-generated method stub
		return	this.JobRepository.UpdateJobDetails(jobdto);
	
}

	
}
	
	


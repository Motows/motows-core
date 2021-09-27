package com.research.jobservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.GarageDAO;
import com.research.garage.dao.OrganisationDAO;
import com.research.garage.entity.OrganisationProjection;
import com.research.garage.iservice.IJobRepository;
import com.research.jobservice.dao.JobCodeDAO;
import com.research.jobservice.dao.JobDAO;
import com.research.jobservice.dto.JobDTO;
import com.research.jobservice.entity.JobProjection;
import com.research.vehicle.dao.ModelDAO;


@Component
public class JobRepository implements IJobRepository {
	@Autowired
	private JobDAO jobDAO;
	@Autowired
	private OrganisationDAO OrganisationDAO;
	@Autowired
	private GarageDAO garageDAO;
	@Autowired
	private JobCodeDAO jobCodeDAO;
	
	@Override

	public String saveDetails(JobDTO jobdto) {
		//OrganisationProjection country = OrganisationDAO.getOne(jobdto.getOrganisationID());
		
		JobProjection job = new JobProjection();
		if(jobCodeDAO.getOne(jobdto.getJobCardID())==null)
		{
			return "JobCardID Required";
		}
		job.setJobCardID(jobdto.getJobCardID());
		
		if(garageDAO.getOne(jobdto.getGarageid())==null)
		{
			return "Garage ID Not Found";
		}
		job.setGarageid(jobdto.getGarageid());
		if(OrganisationDAO.getOne(jobdto.getOrganisationID())==null)
		{
			return "Organization Not Found";
		}
		if(!(jobdto.getJobtype().equals("Job") || jobdto.getJobtype().equals("Voice")))
		{
			return "Job type should be Job or Voice";
		}
		job.setOrganisationID(jobdto.getOrganisationID());
		job.setJob_Description(jobdto.getJob_Description());
		job.setJobStatus(jobdto.getJobStatus());
		job.setPrice(jobdto.getPrice());
		job.setJob_type(jobdto.getJobtype());
		
		jobDAO.save(job);
		return "Details Saved";
	}

	@Override
	public JobDTO getJobdetailsById(String jobId) {
		JobProjection job = jobDAO.getOne(jobId);

		JobDTO response = new JobDTO();
       if(job!=null)
       {
		response.setJobID(job.getJobID());
		response.setJobCardID(job.getJobCardID());
		response.setGarageid(job.getGarageid());
		response.setOrganisationID(job.getOrganisationID());
		response.setJob_Description(job.getJob_Description());
		response.setJobStatus(job.getJobStatus());
		response.setPrice(job.getPrice());
		response.setJobtype(job.getJob_type());
       }

		return response;
	}
	
	@Override
	public List<JobDTO> getjobdetailsByJobCardID(String jobCardId) {
	List<JobProjection> jobList = jobDAO.getList(jobCardId);
	List<JobDTO> jobDtoList = new ArrayList<JobDTO>();
	for(JobProjection job:jobList)
       {

		JobDTO response = new JobDTO();
		response.setJobID(job.getJobID());
		response.setJobCardID(job.getJobCardID());
		response.setGarageid(job.getGarageid());
		response.setOrganisationID(job.getOrganisationID());
		response.setJob_Description(job.getJob_Description());
		response.setJobStatus(job.getJobStatus());
		response.setPrice(job.getPrice());
		response.setJobtype(job.getJob_type());
		jobDtoList.add(response);
       }

		return jobDtoList;
	}

	
	
	


	@Override
	public String deletejobById(String jobId) {

		jobDAO.deletejobById(jobId);

		return "deleted";
	}


	@Override
	public String UpdateJobDetails(JobDTO jobdto) {
		JobProjection job = jobDAO.getOne(jobdto.getJobID());
		job.setJobID(job.getJobID());
		job.setJobCardID(job.getJobCardID());
		job.setGarageid(job.getGarageid());
		job.setOrganisationID(job.getOrganisationID());
		job.setJob_Description(job.getJob_Description());
		job.setJobStatus(job.getJobStatus());
		job.setPrice(job.getPrice());
		job.setJob_type(job.getJob_type());
		jobDAO.save(job);
		return "updated";
	}
	
}

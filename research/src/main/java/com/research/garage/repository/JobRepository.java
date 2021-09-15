package com.research.garage.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.JobDAO;
import com.research.garage.dao.OrganisationDAO;
import com.research.garage.entity.JobProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.garage.iservice.IJobRepository;
import com.research.jobservice.dto.JobDTO;


@Component
public class JobRepository implements IJobRepository {
	@Autowired
	private JobDAO jobDAO;
	@Autowired
	private OrganisationDAO OrganisationDAO;

	@Override

	public String saveDetails(JobDTO jobdto) {
		OrganisationProjection country = OrganisationDAO.getOne(jobdto.getOrganisationID());
		
		JobProjection job = new JobProjection();
		job.setJob_Description(jobdto.getJobDescription());
		job.setJob_Description_Caption(jobdto.getJobDescriptionCaption());
		job.setJob_DescriptionUI(jobdto.getJobDescriptionUI());
		job.setModel(jobdto.getModel());
		job.setOrganisation(country);
		jobDAO.save(job);
		return "Details Saved";
	}

	@Override
	public JobDTO getJobdetailsById(String jobId) {
		JobProjection job = jobDAO.getOne(jobId);

		JobDTO response = new JobDTO();

		response.setJobDescription(job.getJob_Description());
		response.setJobDescriptionCaption(job.getJob_Description_Caption());
		response.setJobDescriptionUI(job.getJob_DescriptionUI());
		response.setModel(job.getModel());
		response.setJobID(job.getJobID());

		return response;
	}


	@Override
	public String deletejobById(String jobId) {

		jobDAO.deletejobById(jobId);

		return "deleted";
	}


	@Override
	public String UpdateJobDetails(JobDTO jobdto) {
		JobProjection job = jobDAO.getOne(jobdto.getJobID());
		job.setJob_Description(jobdto.getJobDescription());
		job.setJob_Description_Caption(jobdto.getJobDescriptionCaption());
		job.setJob_DescriptionUI(jobdto.getJobDescriptionUI());
		job.setModel(jobdto.getModel());
		job.setJobID(jobdto.getJobID());
		jobDAO.save(job);
		return "updated";
	}
	
}

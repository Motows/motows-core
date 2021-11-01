package com.research.jobservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dao.JobCardStatusDAO;
import com.research.jobservice.dto.JobCardStatusDTO;
import com.research.jobservice.entity.JobCardStatusProjection;
import com.research.jobservice.iservice.IJobCardStatusRepository;

@Component
public class JobCardStatusRepository implements IJobCardStatusRepository {

	@Autowired
	private JobCardStatusDAO jobCardStatusDAO;

	@Override
	public String addJobCardStatus(JobCardStatusDTO jobCardStatusDTO) {
		JobCardStatusProjection jobCardStatus = new JobCardStatusProjection();
		jobCardStatus.setJob_Status(jobCardStatusDTO.getJobStatus());
		jobCardStatusDAO.save(jobCardStatus);

		return "Job Card Status Saved";
	}

	@Override
	public JobCardStatusDTO getJobCardStatusById(String jobCardStatusId) {
		JobCardStatusProjection jobCardStatus = jobCardStatusDAO.getOne(jobCardStatusId);

		JobCardStatusDTO jobCardStatusDTO = new JobCardStatusDTO();
		if(jobCardStatusId==null)
		{
			jobCardStatusDTO.setJobCardStatusId("Invalid ID:"+jobCardStatusId);
			return jobCardStatusDTO;
		}
		jobCardStatusDTO.setJobCardStatusId(jobCardStatus.getJob_Card_Status_Id());
		jobCardStatusDTO.setJobStatus(jobCardStatus.getJob_Status());

		return jobCardStatusDTO;
	}

	@Override
	public String deleteJobCardStatusById(String jobCardStatusId) {
		if(jobCardStatusDAO.getOne(jobCardStatusId)!=null)
		{

			jobCardStatusDAO.deleteById(jobCardStatusId);
			return "Job Card Status Deleted";
		}
		else
		{
			return "Job Card Status id Not found";
		}
	}

	@Override
	public String updateJobCardStatus(JobCardStatusDTO jobCardStatusDTO) {
		JobCardStatusProjection jobCardStatus = jobCardStatusDAO.getOne(jobCardStatusDTO.getJobCardStatusId());

		jobCardStatus.setJob_Status(jobCardStatusDTO.getJobStatus());
		jobCardStatusDAO.save(jobCardStatus);
		return "Job Card Status Updated";

	}

}

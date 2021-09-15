package com.research.jobservice.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dao.JobCodeDAO;
import com.research.jobservice.dto.JobCodeDTO;
import com.research.jobservice.entity.JobCardProjection;
import com.research.jobservice.iservice.IJobCodeRepositry;
@Component
public class JobCodeRepository implements IJobCodeRepositry{
	
	@Autowired
	private JobCodeDAO JobCodeDAO;

	@Override
	public String saveDetails(JobCodeDTO jobcodeto) {

		JobCardProjection Jobcard = new JobCardProjection();
		Jobcard.setOrganisationID(jobcodeto.getOrganisationID());
		Jobcard.setJob_Card_Type(jobcodeto.getJobCardType());
		Jobcard.setJob_Card_Status(jobcodeto.getJobCardStatus());
		Jobcard.setJobCreationDate(jobcodeto.getJobCreationDate());
		Jobcard.setEstimated_Completion_Date(jobcodeto.getEstimatedCompletionDate());
		Jobcard.setVehicle_Reg_No(jobcodeto.getVehicleRegNo());
		Jobcard.setEmployeeID(jobcodeto.getEmployeeID());
		Jobcard.setCustomerID(jobcodeto.getCustomerID());
		JobCodeDAO.save(Jobcard);
		return "JobCard Saved";

	}
	@Override
	public JobCodeDTO getjobCodedetails(String jobcodeId) {
		JobCardProjection Jobcard =	JobCodeDAO.getOne(jobcodeId);
		
		JobCodeDTO jobcodeto  = new JobCodeDTO();
		jobcodeto.setJobCardID(Jobcard.getJob_CardID());
		jobcodeto.setOrganisationID(Jobcard.getOrganisationID());
		jobcodeto.setJobCardType(Jobcard.getJob_Card_Type());
		jobcodeto.setJobCardStatus(Jobcard.getJob_Card_Status());
		jobcodeto.setJobCreationDate(Jobcard.getJobCreationDate());
		jobcodeto.setEstimatedCompletionDate(Jobcard.getEstimated_Completion_Date());
		jobcodeto.setVehicleRegNo(Jobcard.getVehicle_Reg_No());
		jobcodeto.setEmployeeID(Jobcard.getEmployeeID());
		jobcodeto.setCustomerID(Jobcard.getCustomerID());
		return jobcodeto;
	}

//	@Override
//	public String deletejobById(String jobcodeId) {
//		JobCodeDAO.deleteById(jobcodeId);
//		
//		return "deleted";
//	}


	@Override
	public String UpdateJobDetails(JobCodeDTO jobcodeto) {
		JobCardProjection Jobcard =	JobCodeDAO.getOne(jobcodeto.getJobCardID());
		Jobcard.setJob_CardID(jobcodeto.getJobCardID());
		Jobcard.setOrganisationID(jobcodeto.getOrganisationID());
		Jobcard.setJob_Card_Type(jobcodeto.getJobCardType());
		Jobcard.setJob_Card_Status(jobcodeto.getJobCardStatus());
		Jobcard.setJobCreationDate(jobcodeto.getJobCreationDate());
		Jobcard.setEstimated_Completion_Date(jobcodeto.getEstimatedCompletionDate());
		Jobcard.setVehicle_Reg_No(jobcodeto.getVehicleRegNo());
		Jobcard.setEmployeeID(jobcodeto.getEmployeeID());
		Jobcard.setCustomerID(jobcodeto.getCustomerID());
		JobCodeDAO.save(Jobcard);

		return "updated";
	}
@Override
public String deletejobCodeById(String jobcodeId) {
	JobCodeDAO.deleteById(jobcodeId);
	return "deleted";
}


	

}
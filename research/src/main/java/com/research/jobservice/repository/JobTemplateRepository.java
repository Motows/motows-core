package com.research.jobservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dao.JobTemplateDAO;
import com.research.jobservice.dto.JobTemplateDTO;
import com.research.jobservice.entity.JobTemplateProjection;
import com.research.jobservice.iservice.IJobTemplateRepository;


@Component
public class JobTemplateRepository implements IJobTemplateRepository {
	@Autowired
	private JobTemplateDAO jobTemplateDAO;

	@Override
	public String addjobtemplateDetails(JobTemplateDTO jtdto) {
		JobTemplateProjection jtpro = new JobTemplateProjection();
		jtpro.setGarage_Id(jtdto.getGarageId());
		jtpro.setJob_Template_Caption(jtdto.getJobTemplateCaption());
		jtpro.setJob_Template_Discription(jtdto.getJobTemplateDiscription());
		jtpro.setJob_Temp_Ui(jtdto.getJobTempUi());
		jtpro.setModel_Id(jtdto.getModelId());
		jtpro.setOrganisation_Id(jtdto.getOrganisationId());
		jobTemplateDAO.save(jtpro);
		return "Job template saved";
		
	}

	@Override
	public JobTemplateDTO getjtbyId(String jobtempId) {
		JobTemplateProjection jtdto = jobTemplateDAO.getOne(jobtempId);
		JobTemplateDTO jtpro = new JobTemplateDTO();
		jtpro.setGarageId(jtdto.getGarage_Id());
		jtpro.setJobTemplateCaption(jtdto.getJob_Template_Caption());
		jtpro.setJobTemplateDiscription(jtdto.getJob_Template_Discription());
		jtpro.setJobTempUi(jtdto.getJob_Temp_Ui());
		jtpro.setModelId(jtdto.getModel_Id());
		jtpro.setOrganisationId(jtdto.getOrganisation_Id());
		jtpro.setJobTemplateId(jtdto.getJob_Template_Id());
		return jtpro;
		
	}

	@Override
	public String deleteJtById(String deleteJtById) {

		jobTemplateDAO.deleteById(deleteJtById);

		return "deleted";
	}
	
	@Override
	public String updateJTDetails(JobTemplateDTO jtdto) {
		JobTemplateProjection jtpro = jobTemplateDAO.getOne(jtdto.getJobTemplateId());
		jtpro.setGarage_Id(jtdto.getGarageId());
		jtpro.setJob_Template_Caption(jtdto.getJobTemplateCaption());
		jtpro.setJob_Template_Discription(jtdto.getJobTemplateDiscription());
		jtpro.setJob_Temp_Ui(jtdto.getJobTempUi());
		jtpro.setModel_Id(jtdto.getModelId());
		jtpro.setOrganisation_Id(jtdto.getOrganisationId());
		jtpro.setJob_Template_Id(jtdto.getJobTemplateId());
		jobTemplateDAO.save(jtpro);
		return "updated";
	}

	
}
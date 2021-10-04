package com.research.jobservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.GarageDAO;
import com.research.garage.dao.OrganisationDAO;
import com.research.jobservice.dao.JobTemplateDAO;
import com.research.jobservice.dto.JobDTO;
import com.research.jobservice.dto.JobTemplateDTO;
import com.research.jobservice.entity.JobProjection;
import com.research.jobservice.entity.JobTemplateProjection;
import com.research.jobservice.iservice.IJobTemplateRepository;
import com.research.vehicle.dao.ModelDAO;


@Component
public class JobTemplateRepository implements IJobTemplateRepository {
	@Autowired
	private JobTemplateDAO jobTemplateDAO;

	@Autowired
	private GarageDAO garageDAO;

	
	@Autowired
	private ModelDAO modelDAO;

	@Autowired
	private OrganisationDAO organisationDAO;

	@Override
	public String addjobtemplateDetails(JobTemplateDTO jtdto) {
		JobTemplateProjection jtpro = new JobTemplateProjection();
		if(jtdto.getCategory()==null || jtdto.getCategory()=="")
		{
			return "Category Required";
		}
		
		
		if(garageDAO.getOne(jtdto.getGarageId())==null)
		{
			return "Garage Not Found";
		}
		
		if(modelDAO.getOne(jtdto.getModelId())==null)
		{
			return "Model Not Found";
		}
		
		if(organisationDAO.getOne(jtdto.getOrganisationId())==null)
		{
			return "Organization Not Found";
		}
		jtpro.setGarage_Id(jtdto.getGarageId());
		jtpro.setJob_Template_Caption(jtdto.getJobTemplateCaption());
		jtpro.setJob_Template_Discription(jtdto.getJobTemplateDiscription());
		jtpro.setJob_Temp_Ui(jtdto.getJobTempUi());
		jtpro.setModel_Id(jtdto.getModelId());
		jtpro.setOrganisation_Id(jtdto.getOrganisationId());
		jtpro.setCategory(jtdto.getCategory());
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
		jtpro.setCategory(jtdto.getCategory());
		jtpro.setPrice(jtdto.getPrice());
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
		
		if(jtdto.getCategory()==null || jtdto.getCategory()=="")
		{
			return "Category Required";
		}
		
		
		if(garageDAO.getOne(jtdto.getGarageId())==null)
		{
			return "Garage Not Found";
		}
		
		if(modelDAO.getOne(jtdto.getModelId())==null)
		{
			return "Model Not Found";
		}
		
		if(organisationDAO.getOne(jtdto.getOrganisationId())==null)
		{
			return "Organization Not Found";
		}
		
		jtpro.setGarage_Id(jtdto.getGarageId());
		jtpro.setJob_Template_Caption(jtdto.getJobTemplateCaption());
		jtpro.setJob_Template_Discription(jtdto.getJobTemplateDiscription());
		jtpro.setJob_Temp_Ui(jtdto.getJobTempUi());
		jtpro.setModel_Id(jtdto.getModelId());
		jtpro.setOrganisation_Id(jtdto.getOrganisationId());
		jtpro.setJob_Template_Id(jtdto.getJobTemplateId());
		jtpro.setCategory(jtdto.getCategory());
		jtpro.setPrice(jtdto.getPrice());
		jobTemplateDAO.save(jtpro);
		return "updated";
	}
	
	@Override
	public List<JobTemplateDTO> getjobdetailsWithCategory(String orgId,String modelID,String category) {
		List<JobTemplateProjection> jobList = jobTemplateDAO.getJobdetailsByAnySearchWithCategory(modelID,orgId,category);
		
		List<JobTemplateDTO> JobDTOList = new ArrayList<JobTemplateDTO>();
		
        for(JobTemplateProjection jtdto:jobList)
        {
        JobTemplateDTO jtpro = new JobTemplateDTO();
        jtpro.setGarageId(jtdto.getGarage_Id());
		jtpro.setJobTemplateCaption(jtdto.getJob_Template_Caption());
		jtpro.setJobTemplateDiscription(jtdto.getJob_Template_Discription());
		jtpro.setJobTempUi(jtdto.getJob_Temp_Ui());
		jtpro.setModelId(jtdto.getModel_Id());
		jtpro.setOrganisationId(jtdto.getOrganisation_Id());
		jtpro.setJobTemplateId(jtdto.getJob_Template_Id());
		jtpro.setCategory(jtdto.getCategory());
		jtpro.setPrice(jtdto.getPrice());
		JobDTOList.add(jtpro);
        }
		return JobDTOList;
	}
	
	@Override
	public List<JobTemplateDTO> getjobdetailsWithDesc(String orgId,String modelID,String desc) {
		List<JobTemplateProjection> jobList = jobTemplateDAO.getJobdetailsByAnySearchWithDesc(modelID,orgId,desc);
		List<JobTemplateDTO> JobDTOList = new ArrayList<JobTemplateDTO>();
	    for(JobTemplateProjection jtdto:jobList)
        {
        JobTemplateDTO jtpro = new JobTemplateDTO();
        jtpro.setGarageId(jtdto.getGarage_Id());
		jtpro.setJobTemplateCaption(jtdto.getJob_Template_Caption());
		jtpro.setJobTemplateDiscription(jtdto.getJob_Template_Discription());
		jtpro.setJobTempUi(jtdto.getJob_Temp_Ui());
		jtpro.setModelId(jtdto.getModel_Id());
		jtpro.setOrganisationId(jtdto.getOrganisation_Id());
		jtpro.setJobTemplateId(jtdto.getJob_Template_Id());
		jtpro.setPrice(jtdto.getPrice());
		JobDTOList.add(jtpro);
        }
		return JobDTOList;
	}

	
}
package com.research.jobservice.iservice;

import java.util.List;


import com.research.jobservice.dto.JobTemplateDTO;

public interface IJobTemplateRepository {

	String addjobtemplateDetails(JobTemplateDTO jtdto);

	JobTemplateDTO getjtbyId(String jobtempId);

	String deleteJtById(String deleteJtById);

	String updateJTDetails(JobTemplateDTO jtdto);
	List<JobTemplateDTO> getjobdetailsWithCategory(String orgId, String modelID, String category);
	
	List<JobTemplateDTO> getjobdetailsWithDesc(String orgId, String modelID,  String desc);

}

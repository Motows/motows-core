package com.research.jobservice.iservice;

import com.research.jobservice.dto.JobTemplateDTO;

public interface IJobTemplateRepository {

	String addjobtemplateDetails(JobTemplateDTO jtdto);

	JobTemplateDTO getjtbyId(String jobtempId);

	String deleteJtById(String deleteJtById);

	String updateJTDetails(JobTemplateDTO jtdto);

}

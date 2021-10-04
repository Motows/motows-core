package com.research.jobservice.iservice;

import com.research.jobservice.dto.JobitemTypeDTO;

public interface IJobItemTypeRepository {

	String addjobItemTypedetails(JobitemTypeDTO jobitemTypeDTO);

	JobitemTypeDTO getjobItemTypedetails(String jobItemTypeId);

	String deletejobItemTypeById(String jobItemTypeId);

	String updatejobItemTypeDetails(JobitemTypeDTO jobitemTypeDTO);
	

}

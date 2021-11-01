package com.research.jobservice.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dao.JobItemTypeDAO;
import com.research.jobservice.dto.JobitemTypeDTO;
import com.research.jobservice.entity.JobitemTypeProjection;
import com.research.jobservice.iservice.IJobItemTypeRepository;


@Component
public class JobItemTypeRepository implements IJobItemTypeRepository {

	@Autowired
	private JobItemTypeDAO jobItemTypeDAO;

	@Override
	public String addjobItemTypedetails(JobitemTypeDTO jobitemTypeDTO) {
		JobitemTypeProjection jobitemtyp = new JobitemTypeProjection();
		jobitemtyp.setJob_Item_Caption(jobitemTypeDTO.getJobItemCaption());
		jobitemtyp.setJob_Item_Name(jobitemTypeDTO.getJobItemName());
		jobitemtyp.setJob_ItemUI(jobitemTypeDTO.getJobItemUI());
		jobItemTypeDAO.save(jobitemtyp);
		return "Job Item Types Saved";
	}
	
	@Override
	public JobitemTypeDTO getjobItemTypedetails(String jobItemTypeId) {
		JobitemTypeProjection jobitemtyp = jobItemTypeDAO.getOne(jobItemTypeId);
		JobitemTypeDTO jobitemtypedto = new JobitemTypeDTO();
		if(jobitemtyp==null)
		{
			jobitemtypedto.setJobitemtypeID("Invalid ID:"+jobItemTypeId);
			return jobitemtypedto;
		}
		jobitemtypedto.setJobItemCaption(jobitemtyp.getJob_Item_Caption());
		jobitemtypedto.setJobItemName(jobitemtyp.getJob_Item_Name());
		jobitemtypedto.setJobItemUI(jobitemtyp.getJob_ItemUI());
		jobitemtypedto.setJobitemtypeID(jobitemtyp.getJobitemtypeID());
		return jobitemtypedto;
	}

	
	@Override
	public String deletejobItemTypeById(String jobItemTypeId) {
		if(jobItemTypeDAO.getOne(jobItemTypeId)!=null)
		{
			jobItemTypeDAO.deleteById(jobItemTypeId);
			return "Job Item Type Deleted";
		}
		else
		{
			return "Job Item Type id Not found";
		}
		
	}


	@Override
	public String updatejobItemTypeDetails(JobitemTypeDTO jobitemTypeDTO) {
		JobitemTypeProjection jobitemtypepro = jobItemTypeDAO.getOne(jobitemTypeDTO.getJobitemtypeID());
		
		jobitemtypepro.setJob_Item_Caption(jobitemTypeDTO.getJobItemCaption());
		jobitemtypepro.setJob_Item_Name(jobitemTypeDTO.getJobItemName());
		jobitemtypepro.setJob_ItemUI(jobitemTypeDTO.getJobItemUI());
		jobitemtypepro.setJobitemtypeID(jobitemTypeDTO.getJobitemtypeID());
		jobItemTypeDAO.save(jobitemtypepro);
		return "Updated Successsfuly";
		
	}

}

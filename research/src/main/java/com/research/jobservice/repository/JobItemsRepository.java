package com.research.jobservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dao.JobCodeDAO;
import com.research.jobservice.dao.JobItemsDAO;
import com.research.jobservice.dto.JobItemsDTO;
import com.research.jobservice.entity.JobItemsProjection;
import com.research.jobservice.iservice.IJobItemsRepository;

@Component
public class JobItemsRepository implements IJobItemsRepository {

	@Autowired
	private JobItemsDAO jobItemsDAO;
	
	@Autowired
	private JobCodeDAO jobCodeDAO;

	@Override
	public String saveJobItems(JobItemsDTO jobItemsDTO) {
		JobItemsProjection jobItems = new JobItemsProjection();
		String jobcardId=jobItemsDTO.getJob_cardid();
		if(jobCodeDAO.getOne(jobcardId)==null)
		{
			return "Job Card Id not available";
		}
		jobItems.setJob_Item_Type(jobItemsDTO.getJobItemType());
		jobItems.setJob_No(jobItemsDTO.getJobNo());
		jobItems.setPrice(jobItemsDTO.getPrice());
		jobItems.setQty(jobItemsDTO.getQty());
		jobItems.setTax(jobItemsDTO.getTax());
		jobItems.setUom(jobItemsDTO.getUom());
		jobItems.setHsn_Or_Sac(jobItemsDTO.getHsnAndSac());
		jobItems.setItemcode(jobItemsDTO.getItemcode());
		jobItems.setItem_status(jobItemsDTO.getItem_status());

		jobItemsDAO.save(jobItems);

		return "Job Items Saved";
	}

	@Override
	public JobItemsDTO getJobItemsById(String jobItemsId) {
		JobItemsProjection jobItem = jobItemsDAO.getOne(jobItemsId);

		JobItemsDTO jobItemsDTO = new JobItemsDTO();

		jobItemsDTO.setJobItemId(jobItem.getJob_Item_Id());
		jobItemsDTO.setJobItemType(jobItem.getJob_Item_Type());
		jobItemsDTO.setJobNo(jobItem.getJob_No());
		jobItemsDTO.setPrice(jobItem.getPrice());
		jobItemsDTO.setQty(jobItem.getQty());
		jobItemsDTO.setTax(jobItem.getTax());
		jobItemsDTO.setUom(jobItem.getUom());
		jobItemsDTO.setHsnAndSac(jobItem.getHsn_Or_Sac());
		jobItemsDTO.setItemcode(jobItem.getItemcode());
		jobItemsDTO.setItem_status(jobItem.getItem_status());

		return jobItemsDTO;
	}

	@Override
	public String deleteJobItemsById(String jobItemsId) {
		jobItemsDAO.deleteById(jobItemsId);
		return "Job Items Deleted";
	}

	@Override
	public String updateJobItems(JobItemsDTO jobItemsDTO) {

		JobItemsProjection jobItems = jobItemsDAO.getOne(jobItemsDTO.getJobItemId());

		jobItems.setJob_Item_Type(jobItemsDTO.getJobItemType());
		jobItems.setJob_No(jobItemsDTO.getJobNo());
		jobItems.setPrice(jobItemsDTO.getPrice());
		jobItems.setQty(jobItemsDTO.getQty());
		jobItems.setTax(jobItemsDTO.getTax());
		jobItems.setUom(jobItemsDTO.getUom());
		jobItems.setHsn_Or_Sac(jobItemsDTO.getHsnAndSac());
		jobItems.setItemcode(jobItemsDTO.getItemcode());
		jobItems.setItem_status(jobItemsDTO.getItem_status());

		jobItemsDAO.save(jobItems);

		return "Job Items Updated";
	}

}

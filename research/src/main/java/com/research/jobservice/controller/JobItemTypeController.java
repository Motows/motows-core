package com.research.jobservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.jobservice.dto.JobitemTypeDTO;
import com.research.jobservice.service.JobitemTypeService;


@RestController
@RequestMapping("api/jobItemType")
public class JobItemTypeController {

	@Autowired
	private JobitemTypeService  JobitemTypeService ;
	
	@PostMapping("/addjobItemTypedetails")
    public String addjobItemTypedetails(@RequestBody JobitemTypeDTO jobitemTypeDTO){
    	return this.JobitemTypeService.addjobItemTypedetails(jobitemTypeDTO);
    }
	
	@GetMapping("/getjobItemTypedetails/{JobItemTypeId}")
	public JobitemTypeDTO getjobItemTypedetails(@PathVariable("JobItemTypeId") String JobItemTypeId) {
		
		return this.JobitemTypeService.getjobItemTypedetails(JobItemTypeId);
	}
	@DeleteMapping("/deletejobItemTypeById/{JobItemTypeId}")
	public String deletejobItemTypeById(@PathVariable("JobItemTypeId") String JobItemTypeId) {
		
		return this.JobitemTypeService.deletejobItemTypeById(JobItemTypeId);
	}
	@PutMapping("/updatejobItemTypeDetails")
	public String updatejobItemTypeDetails(@RequestBody JobitemTypeDTO jobitemTypeDTO) {
		return this.JobitemTypeService.updatejobItemTypeDetails(jobitemTypeDTO);
	}
	
	
}
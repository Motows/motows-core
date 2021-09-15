package com.research.garage.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.service.JobService;
import com.research.jobservice.dto.JobDTO;

@RestController
@RequestMapping("api/job")
public class JobController {

	@Autowired
	private JobService JobService;
	
	@PostMapping("/addjobdetails")
    public String addJobdetails(@RequestBody JobDTO jobdto){
    	return this.JobService.addJobdetails(jobdto);
    }
	
	@GetMapping("/getjobdetails/{JobId}")
	public JobDTO getJobdetailsById(@PathVariable("JobId") String JobId) {
		
		return this.JobService.getJobdetailsById(JobId);
	}
	@DeleteMapping("/deleteById/{JobId}")
	public String deletejobById(@PathVariable("JobId") String JobId) {
		
		return this.JobService.deletejobById(JobId);
	}
	@PostMapping("/updateJobDetails")
	public String UpdateJobDetails(@RequestBody JobDTO jobdto) {
		return this.JobService.UpdateJobDetails(jobdto);
	}
	
	
}

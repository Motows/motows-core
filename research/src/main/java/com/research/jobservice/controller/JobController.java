package com.research.jobservice.controller;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.research.jobservice.dto.JobDTO;
import com.research.jobservice.dto.JobSearchDTO;
import com.research.jobservice.service.JobService;

import io.swagger.annotations.ApiModelProperty;

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
	
	@GetMapping("/getjobdetailsByJobCardID/{JobCardId}")
	public List<JobDTO> getjobdetailsByJobCardID(@PathVariable("JobCardId") String JobCardId) {
		
		return this.JobService.getjobdetailsByJobCardID(JobCardId);
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

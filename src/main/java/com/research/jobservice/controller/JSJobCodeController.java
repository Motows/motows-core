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

import com.research.jobservice.dto.JobCodeDTO;
import com.research.jobservice.service.JobCodeService;

import io.swagger.annotations.Api;

@Api(description = "Job Code Controller", tags = { "Job Service Job Code" })
@RestController
@RequestMapping("api/job")
public class JSJobCodeController {

	@Autowired
	private JobCodeService JobCodeService;
	
	@PostMapping("/addjobCodedetails")
    public String addjobCode(@RequestBody JobCodeDTO jobcodeto){
    	return this.JobCodeService.addjobCoded(jobcodeto);
    }
	
	@GetMapping("/getjobCodedetails/{JobcodeId}")
	public JobCodeDTO getjobCodedetails(@PathVariable("JobcodeId") String JobcodeId) {
		
		return this.JobCodeService.getjobCodedetails(JobcodeId);
	}
	@DeleteMapping("/deletejobCodeById/{JobcodeId}")
	public String deletejobCodeById(@PathVariable("JobcodeId") String JobcodeId) {
		
		return this.JobCodeService.deletejobCodeById(JobcodeId);
	}
	@PutMapping("/updatejobCodedetails")
	public String updatejobCodedetails(@RequestBody JobCodeDTO jobcodeto) {
		return this.JobCodeService.updatejobCodedetails(jobcodeto);
	}
	
	
}

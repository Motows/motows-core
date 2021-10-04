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

import com.research.jobservice.dto.JobCardStatusDTO;
import com.research.jobservice.service.JobCardStatusService;

import io.swagger.annotations.Api;
@Api(description = "Job Card Status Controller", tags = { "Job Service Job Card Status" })
@RestController
@RequestMapping("api/jobcardStatus")
public class JSJobCardStatusController {
	@Autowired
	private JobCardStatusService jobCardStatusService;

	@PostMapping
	public String addJobCardStatus(@RequestBody JobCardStatusDTO jobCardStatusDTO) {
		return this.jobCardStatusService.addJobCardStatus(jobCardStatusDTO);
	}
	
	@GetMapping("/{jobCardStatusId}")
	public JobCardStatusDTO getJobCardStatusById(@PathVariable String jobCardStatusId) {
		return this.jobCardStatusService.getJobCardStatusById(jobCardStatusId);
	}
	@DeleteMapping("/{jobCardStatusId}")
	public String deleteJobCardStatus(@PathVariable String jobCardStatusId) {
		return this.jobCardStatusService.deleteJobCardStatusById(jobCardStatusId);
	}
	@PutMapping
	public String UpdateJobCardStatus(@RequestBody JobCardStatusDTO jobCardStatusDTO) {
		return this.jobCardStatusService.UpdateJobCardStatus(jobCardStatusDTO);
	}
	
}

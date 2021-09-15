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

import com.research.jobservice.dto.JobItemsDTO;
import com.research.jobservice.service.JobItemsService;

@RestController
@RequestMapping("api/jobitems")
public class JobItemsController {

	@Autowired
	private JobItemsService jobItemService;

	@PostMapping
	public String AddJobItems(@RequestBody JobItemsDTO jobItemsDTO) {
		return this.jobItemService.addJobItems(jobItemsDTO);
	}

	@GetMapping("/{jobItemsId}")
	public JobItemsDTO getJobItemsById(@PathVariable String jobItemsId) {
		return this.jobItemService.getJobItemsById(jobItemsId);
	}

	@DeleteMapping("/{jobItemsId}")
	public String DeleteJobItemsById(@PathVariable String jobItemsId) {
		return this.jobItemService.DeleteJobItemsById(jobItemsId);
	}

	@PutMapping
	public String updateJobItems(@RequestBody JobItemsDTO jobItemsDTO) {

		return this.jobItemService.updateJobItesm(jobItemsDTO);

	}
}

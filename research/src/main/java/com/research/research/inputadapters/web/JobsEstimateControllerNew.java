package com.research.research.inputadapters.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.research.outputadapters.repositories.VINRepositoryNew;
import com.research.research.outputadapters.repositories.Vin;
import com.research.research.outputadapters.repositories.CustomerNew;
import com.research.research.outputadapters.repositories.JobNew;
import com.research.research.outputadapters.repositories.JobRepositoryNew;
import com.research.research.outputadapters.repositories.JobsEstimateNew;
import com.research.research.outputadapters.repositories.JobsEstimateRepositoryNew;



@RestController
@RequestMapping("JobsEstimateNew")
public class JobsEstimateControllerNew {

	@Autowired
	JobsEstimateRepositoryNew jobsEstimateRepository;
	

	@Autowired
	JobRepositoryNew jobRepository;
	
	// retrieve all JobEstimate from database
	@GetMapping("all")
	public List<JobsEstimateNew> getAllJobEstimate()
	{
		List<JobsEstimateNew> jobsEstimate=(List<JobsEstimateNew>) jobsEstimateRepository.findAll(); 
		return jobsEstimate;
	}
	
	// insert new JobEstimate into database
	@PostMapping("add")
	public JobsEstimateNew addJobEstimate(@RequestBody JobsEstimateNew jobsEstimate)
	{
		System.out.print("jobsEstimate: "+jobsEstimate);
		return jobsEstimateRepository.save(jobsEstimate);
	}
	
	// get particular JobEstimate by their ID
	@GetMapping("JobEstimate/{id}")
	public Optional<JobsEstimateNew> getJobEstimateId(@PathVariable int id)
	{
		return jobsEstimateRepository.findById(id);
	}
	
	// update existing JobEstimate 
	@PutMapping("update/{id}")
	public JobsEstimateNew updateJobEstimate(@RequestBody JobsEstimateNew jobsEstimate,@PathVariable int id)
	{
		jobsEstimate.setId(id);
		return jobsEstimateRepository.save(jobsEstimate);
	}
	
	// delete particular JobEstimate from database
	@DeleteMapping("delete/{id}")
	public void deleteJobEstimate(@PathVariable int id)
	{
		jobsEstimateRepository.deleteById(id);
	}
	

}

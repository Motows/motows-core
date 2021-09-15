package com.research.research.inputadapters.web;

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


import com.research.research.outputadapters.repositories.JobNew;
import com.research.research.outputadapters.repositories.JobRepositoryNew;
import com.research.research.outputadapters.repositories.VINRepositoryNew;
import com.research.research.outputadapters.repositories.Vin;


@RestController
@RequestMapping("JobNew")
public class JobControllerNew {

	@Autowired
	JobRepositoryNew jobRepository;
	
	// retrieve all Vin from database
	@GetMapping("all")
	public List<JobNew> getAllJob()
	{
		List<JobNew> job=(List<JobNew>) jobRepository.findAll(); 
		return job;
	}
	
	// insert new Vin into database
	@PostMapping("add")
	public JobNew addJob(@RequestBody JobNew job)
	{
		System.out.print("Job: "+job);
		return jobRepository.save(job);
	}
	
	// get particular Vin by their ID
	@GetMapping("Job/{id}")
	public Optional<JobNew> getVinId(@PathVariable int id)
	{
		return jobRepository.findById(id);
	}
	
	// update existing Vin 
	@PutMapping("update/{id}")
	public JobNew updateJob(@RequestBody JobNew job,@PathVariable int id)
	{
		job.setId(id);
		return jobRepository.save(job);
	}
	
	// delete particular Vin from database
	@DeleteMapping("delete/{id}")
	public void deleteJob(@PathVariable int id)
	{
		jobRepository.deleteById(id);
	}
}

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
import com.research.research.outputadapters.repositories.PartsEstimateNew;
import com.research.research.outputadapters.repositories.PartsEstimateRepositoryNew;



@RestController
@RequestMapping("PartsEstimateNew")
public class PartsEstimateControllerNew {

	@Autowired
	PartsEstimateRepositoryNew partsEstimateRepository;
	

	@Autowired
	JobRepositoryNew jobRepository;
	
	// retrieve all JobEstimate from database
	@GetMapping("all")
	public List<PartsEstimateNew> getAllJobEstimate()
	{
		List<PartsEstimateNew> partsEstimate=(List<PartsEstimateNew>) partsEstimateRepository.findAll(); 
		return partsEstimate;
	}
	
	// insert new JobEstimate into database
	@PostMapping("add")
	public PartsEstimateNew addJobEstimate(@RequestBody PartsEstimateNew partsEstimate)
	{
		System.out.print("partsEstimate: "+partsEstimate);
		return partsEstimateRepository.save(partsEstimate);
	}
	
	// get particular JobEstimate by their ID
	@GetMapping("JobEstimate/{id}")
	public Optional<PartsEstimateNew> getJobEstimateId(@PathVariable int id)
	{
		return partsEstimateRepository.findById(id);
	}
	
	// update existing JobEstimate 
	@PutMapping("update/{id}")
	public PartsEstimateNew updateJobEstimate(@RequestBody PartsEstimateNew partsEstimate,@PathVariable int id)
	{
		partsEstimate.setId(id);
		return partsEstimateRepository.save(partsEstimate);
	}
	
	// delete particular JobEstimate from database
	@DeleteMapping("delete/{id}")
	public void deleteJobEstimate(@PathVariable int id)
	{
		partsEstimateRepository.deleteById(id);
	}
	

}

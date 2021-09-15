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
import com.research.research.outputadapters.repositories.PartsNew;
import com.research.research.outputadapters.repositories.PartsRepositoryNew;
import com.research.research.outputadapters.repositories.PartsRepositoryNew;


@RestController
@RequestMapping("PartsNew")
public class PartsControllerNew {

	@Autowired
	PartsRepositoryNew partsRepository;
	

	@Autowired
	JobRepositoryNew jobRepository;
	
	// retrieve all Parts from database
	@GetMapping("all")
	public List<PartsNew> getAllParts()
	{
		List<PartsNew> parts=(List<PartsNew>) partsRepository.findAll(); 
		return parts;
	}
	
	// insert new Parts into database
	@PostMapping("add")
	public PartsNew addParts(@RequestBody PartsNew parts)
	{
		System.out.print("parts: "+parts);
		return partsRepository.save(parts);
	}
	
	// get particular Parts by their ID
	@GetMapping("Parts/{id}")
	public Optional<PartsNew> getPartsId(@PathVariable int id)
	{
		return partsRepository.findById(id);
	}
	
	// update existing Parts 
	@PutMapping("update/{id}")
	public PartsNew updateParts(@RequestBody PartsNew parts,@PathVariable int id)
	{
		parts.setId(id);
		return partsRepository.save(parts);
	}
	
	// delete particular Parts from database
	@DeleteMapping("delete/{id}")
	public void deleteParts(@PathVariable int id)
	{
		partsRepository.deleteById(id);
	}
	
//	@GetMapping("getCateogory/{parts_id}")
//	public List<JobNew> getCateogory(@PathVariable(value = "parts_id") String parts_id)
//	{
//		List<PartsNew> partsList=(List<PartsNew>) partsRepository.findAll(); 
//		List<String> cat_arr = new ArrayList<String>();
//		//PartsNew fil_parts = partsList.stream().filter(parts_tmp -> parts_id.equals(parts_tmp.getParts_id())).findAny().orElse(null);
//		
//		for(PartsNew obj:partsList)
//    	 {
//			if(parts_id.equals(obj.getParts_id()))
//				cat_arr.add(obj.getCategory_name());
//    	 }
//		JobNew fil_JobNew=new JobNew();
//		List<JobNew> jobListFinal = new ArrayList<JobNew>();
//		List<JobNew> jobList=(List<JobNew>) jobRepository.findAll();
//		if(cat_arr!=null)
//	    {
//			for(String category:cat_arr)
//	    	 {
//	    	System.out.print("cat_name"+category);
//	    	for(JobNew obj:jobList)
//	    	 {
//	    		if(category.equals(obj.getCategory_name()))
//	    			jobListFinal.add(obj);
//	    	 }
//	    	}
//	    }
//	    return jobListFinal;
//	}
}

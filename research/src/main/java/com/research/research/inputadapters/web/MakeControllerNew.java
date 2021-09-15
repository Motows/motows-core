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
import com.research.research.outputadapters.repositories.MakeNew;
import com.research.research.outputadapters.repositories.MakeRepositoryNew;


@RestController
@RequestMapping("MakeNew")
public class MakeControllerNew {

	@Autowired
	MakeRepositoryNew makeRepository;
	
	
	// retrieve all Make from database
	@GetMapping("all")
	public List<MakeNew> getAllMake()
	{
		List<MakeNew> make=(List<MakeNew>) makeRepository.findAll(); 
		return make;
	}
	
	// insert new Make into database
	@PostMapping("add")
	public MakeNew addMake(@RequestBody MakeNew make)
	{
		System.out.print("make: "+make);
		return makeRepository.save(make);
	}
	
	// get particular Make by their ID
	@GetMapping("Make/{id}")
	public Optional<MakeNew> getMakeId(@PathVariable int id)
	{
		return makeRepository.findById(id);
	}
	
	// update existing Make 
	@PutMapping("update/{id}")
	public MakeNew updateMake(@RequestBody MakeNew make,@PathVariable int id)
	{
		make.setId(id);
		return makeRepository.save(make);
	}
	
	// delete particular Make from database
	@DeleteMapping("delete/{id}")
	public void deleteMake(@PathVariable int id)
	{
		makeRepository.deleteById(id);
	}
	
//	@GetMapping("getCateogory/{make_id}")
//	public List<JobNew> getCateogory(@PathVariable(value = "make_id") String make_id)
//	{
//		List<MakeNew> makeList=(List<MakeNew>) makeRepository.findAll(); 
//		List<String> cat_arr = new ArrayList<String>();
//		//MakeNew fil_make = makeList.stream().filter(make_tmp -> make_id.equals(make_tmp.getMake_id())).findAny().orElse(null);
//		
//		for(MakeNew obj:makeList)
//    	 {
//			if(make_id.equals(obj.getMake_id()))
//				cat_arr.add(obj.getJob_id());
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

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
import com.research.research.outputadapters.repositories.ModelNew;
import com.research.research.outputadapters.repositories.ModelRepositoryNew;


@RestController
@RequestMapping("ModelNew")
public class ModelControllerNew {

	@Autowired
	ModelRepositoryNew modelRepository;
	

	@Autowired
	JobRepositoryNew jobRepository;
	
	// retrieve all Model from database
	@GetMapping("all")
	public List<ModelNew> getAllModel()
	{
		List<ModelNew> model=(List<ModelNew>) modelRepository.findAll(); 
		return model;
	}
	
	// insert new Model into database
	@PostMapping("add")
	public ModelNew addModel(@RequestBody ModelNew model)
	{
		System.out.print("model: "+model);
		return modelRepository.save(model);
	}
	
	// get particular Model by their ID
	@GetMapping("Model/{id}")
	public Optional<ModelNew> getModelId(@PathVariable int id)
	{
		return modelRepository.findById(id);
	}
	
	// update existing Model 
	@PutMapping("update/{id}")
	public ModelNew updateModel(@RequestBody ModelNew model,@PathVariable int id)
	{
		model.setId(id);
		return modelRepository.save(model);
	}
	
	// delete particular Model from database
	@DeleteMapping("delete/{id}")
	public void deleteModel(@PathVariable int id)
	{
		modelRepository.deleteById(id);
	}
	
	@GetMapping("getCateogory/{model_id}")
	public List<JobNew> getCateogory(@PathVariable(value = "model_id") String model_id)
	{
		List<ModelNew> modelList=(List<ModelNew>) modelRepository.findAll(); 
		List<String> cat_arr = new ArrayList<String>();
		//ModelNew fil_model = modelList.stream().filter(model_tmp -> model_id.equals(model_tmp.getModel_id())).findAny().orElse(null);
		
		for(ModelNew obj:modelList)
    	 {
			if(model_id.equals(obj.getModel_id()))
				cat_arr.add(obj.getJob_id());
    	 }
		JobNew fil_JobNew=new JobNew();
		List<JobNew> jobListFinal = new ArrayList<JobNew>();
		List<JobNew> jobList=(List<JobNew>) jobRepository.findAll();
		if(cat_arr!=null)
	    {
			for(String category:cat_arr)
	    	 {
	    	System.out.print("cat_name"+category);
	    	for(JobNew obj:jobList)
	    	 {
	    		if(category.equals(obj.getCategory_name()))
	    			jobListFinal.add(obj);
	    	 }
	    	}
	    }
	    return jobListFinal;
	}
}

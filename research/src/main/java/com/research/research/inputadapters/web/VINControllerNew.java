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

import com.research.research.outputadapters.repositories.CustomerNew;
import com.research.research.outputadapters.repositories.Estimate;
import com.research.research.outputadapters.repositories.JobNew;
import com.research.research.outputadapters.repositories.JobRepositoryNew;
import com.research.research.outputadapters.repositories.ModelNew;
import com.research.research.outputadapters.repositories.ModelRepositoryNew;
import com.research.research.outputadapters.repositories.PartsNew;
import com.research.research.outputadapters.repositories.PartsRepositoryNew;
import com.research.research.outputadapters.repositories.VINRepositoryNew;
import com.research.research.outputadapters.repositories.Vin;
import com.research.research.outputadapters.repositories.VoiceNew;
import com.research.research.outputadapters.repositories.VoiceRepositoryNew;


@RestController
@RequestMapping("VIN")
public class VINControllerNew {

	@Autowired
	VINRepositoryNew vinRepository;
	
	@Autowired
	ModelRepositoryNew modelRepository;
	

	@Autowired
	JobRepositoryNew jobRepository;
	
	@Autowired
	VoiceRepositoryNew voiceRepository;
	
	@Autowired
	PartsRepositoryNew partsRepository;
	
	
	// retrieve all Vin from database
	@GetMapping("all")
	public List<Vin> getAllVin()
	{
		List<Vin> vin=(List<Vin>) vinRepository.findAll(); 
		return vin;
	}
	
	// insert new Vin into database
	@PostMapping("add")
	public Vin addVin(@RequestBody Vin vin)
	{
		System.out.print("vin: "+vin);
		return vinRepository.save(vin);
	}
	
	// get particular Vin by their ID
	@GetMapping("Vin/{id}")
	public Optional<Vin> getVinId(@PathVariable int id)
	{
		return vinRepository.findById(id);
	}
	
	// update existing Vin 
	@PutMapping("update/{id}")
	public Vin updateVin(@RequestBody Vin vin,@PathVariable int id)
	{
		vin.setId(id);
		return vinRepository.save(vin);
	}
	
	// delete particular Vin from database
	@DeleteMapping("delete/{id}")
	public void deleteVin(@PathVariable int id)
	{
		vinRepository.deleteById(id);
	}
	
	@GetMapping("getEstimate/{id}")
	public Estimate getCustomerphone(@PathVariable(value = "id") int id)
	{
		Estimate estimate=new Estimate();
		Optional<Vin> veh_details= vinRepository.findById(id);
		String model_id=veh_details.get().getModel_id();
		List<ModelNew> modelList=(List<ModelNew>) modelRepository.findAll(); 
		List<String> cat_arr = new ArrayList<String>();
		//ModelNew fil_model = modelList.stream().filter(model_tmp -> model_id.equals(model_tmp.getModel_id())).findAny().orElse(null);
		int total=0;
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
	    		{
	    			jobListFinal.add(obj);
	    			total=total+obj.getPrice();
	    		}
	    	 }
	    	}
	    }
	    estimate.setJobs(jobList);
	    
	    List<VoiceNew> voice_details= (List<VoiceNew>) voiceRepository.findAll();
	    List<VoiceNew> voice_detailsFinal= new ArrayList<VoiceNew>();
	    String idStr=String.valueOf(id);
	    
	    for(VoiceNew voiceobj:voice_details)
	    	{
			if(idStr.equals(voiceobj.getVehicle_id()))
			{
				voice_detailsFinal.add(voiceobj);
				total=total+voiceobj.getPrice();
			}
	     }
	    
	    estimate.setVoice(voice_detailsFinal);
	    
	    List<PartsNew> parts_details= (List<PartsNew>) partsRepository.findAll();
	    List<PartsNew> parts_detailsFinal= new ArrayList<PartsNew>();
	   
//	    for(PartsNew partsobj:parts_details)
//	    	{
//			if(idStr.equals(partsobj.getVehicle_id()))
//			{
//				parts_detailsFinal.add(partsobj);
//				total=total+partsobj.getPart_price();
//			}
//	     }
	    
	    estimate.setParts(parts_detailsFinal);
	    estimate.setTotal(total);
	    return estimate;
	}
}

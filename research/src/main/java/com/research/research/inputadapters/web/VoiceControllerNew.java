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
import com.research.research.outputadapters.repositories.VoiceNew;
import com.research.research.outputadapters.repositories.VoiceRepositoryNew;


@RestController
@RequestMapping("VoiceNew")
public class VoiceControllerNew {

	@Autowired
	VoiceRepositoryNew voiceRepository;
	

	@Autowired
	JobRepositoryNew jobRepository;
	
	// retrieve all Voice from database
	@GetMapping("all")
	public List<VoiceNew> getAllVoice()
	{
		List<VoiceNew> voice=(List<VoiceNew>) voiceRepository.findAll(); 
		return voice;
	}
	
	// insert new Voice into database
	@PostMapping("add")
	public VoiceNew addVoice(@RequestBody VoiceNew voice)
	{
		System.out.print("voice: "+voice);
		return voiceRepository.save(voice);
	}
	
	// get particular Voice by their ID
	@GetMapping("Voice/{id}")
	public Optional<VoiceNew> getVoiceId(@PathVariable int id)
	{
		return voiceRepository.findById(id);
	}
	
	// update existing Voice 
	@PutMapping("update/{id}")
	public VoiceNew updateVoice(@RequestBody VoiceNew voice,@PathVariable int id)
	{
		voice.setId(id);
		return voiceRepository.save(voice);
	}
	
	// delete particular Voice from database
	@DeleteMapping("delete/{id}")
	public void deleteVoice(@PathVariable int id)
	{
		voiceRepository.deleteById(id);
	}
	
//	@GetMapping("getCateogory/{voice_id}")
//	public List<JobNew> getCateogory(@PathVariable(value = "voice_id") String voice_id)
//	{
//		List<VoiceNew> voiceList=(List<VoiceNew>) voiceRepository.findAll(); 
//		List<String> cat_arr = new ArrayList<String>();
//		//VoiceNew fil_voice = voiceList.stream().filter(voice_tmp -> voice_id.equals(voice_tmp.getVoice_id())).findAny().orElse(null);
//		
//		for(VoiceNew obj:voiceList)
//    	 {
//			if(voice_id.equals(obj.getVoice_id()))
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

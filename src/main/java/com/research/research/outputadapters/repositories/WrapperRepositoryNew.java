package com.research.research.outputadapters.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.research.garage.dto.CustomerDTO;
import com.research.garage.dto.VehicelDetailsDTO;
import com.research.garage.entity.CustomerProjection;
import com.research.garage.service.CustomerService;
import com.research.research.applicationservices.spi.IWrapperRepository;
import com.research.research.applicationservices.spi.IWrapperRepositoryNew;
import com.research.vehicle.entity.VINProjection;
import com.research.vehicle.entity.VIN_ContactProjection;

@Component
public class WrapperRepositoryNew implements IWrapperRepositoryNew {

//	@Autowired
//	private CustomerRepositoryNew customerrepository;
//
//		
//	@Autowired
//	private VINRepositoryNew vinRepository;
//	
//	@Autowired
//	private JobsEstimateRepositoryNew jobEstimaterepository;
//	
//	@Autowired
//	private JobRepositoryNew jobrepository;
//	
//	@Autowired
//	private ModelRepositoryNew modelrepository;
//	
//	@Autowired
//	private MakeRepositoryNew makerepository;
//	
//	@Autowired
//	private PartsEstimateRepositoryNew partsEstimaterepository;
//	
//	@Autowired
//	private PartsRepositoryNew partrepository;
//	
//	@Autowired
//	private VoiceRepositoryNew voicerepository;
//	
//	@Autowired
//	private VoiceEstimateRepositoryNew voiceEstimaterepository;

	
	@Override
	public List<CustomerNew> getAllCustomerDataWithAny(String searchStr) {
		// TODO Auto-generated method stub
//		List<CustomerNew> customer=(List<CustomerNew>) customerrepository.findAll(); 
//		List<CustomerNew> result = customer.stream()                // convert list to stream
//	                .filter(obj -> searchStr.equals(obj.getCustomerName()))     // we dont like mkyong
//	                .collect(Collectors.toList());
//		if(result.isEmpty())
//		{
//			result = customer.stream()                // convert list to stream
//	                .filter(obj -> searchStr.equals(obj.getMobile_no()))     // we dont like mkyong
//	                .collect(Collectors.toList());
//		}
//		if(result.isEmpty())
//		{
//			List<Vin> vehicle=(List<Vin>) vinRepository.findAll();
//			List<Vin> veh_result = vehicle.stream()                // convert list to stream
//        .filter(obj -> searchStr.equals(obj.getVin_no()))     // we dont like mkyong
//        .collect(Collectors.toList());
//			
//			for(Vin obj:veh_result)
//	    	 {
//				result.add(customer.stream().filter(name -> obj.getCustomerID()==name.getId()).findAny().orElse(null));
//	    	 }
//		}
//		return result;
		return null;
	}


	@Override
	public Estimate getEstimate(int vehicle_id) {
		// TODO Auto-generated method stub
//		Estimate estimate=new Estimate();
//		List<JobsEstimateNew> jobEstimateList=(List<JobsEstimateNew>) jobEstimaterepository.findAll(); 
//		List<String> job_arr = new ArrayList<String>();
//		int total=0;
//		for(JobsEstimateNew obj:jobEstimateList)
//    	 {
//			if(String.valueOf(vehicle_id).equals(obj.getVehicle_id()))
//				job_arr.add(obj.getJob_id());
//    	 }
//		List<JobNew> jobListFinal = new ArrayList<JobNew>();
//		List<JobNew> jobList=(List<JobNew>) jobrepository.findAll();
//		if(job_arr!=null)
//	    {
//			for(String job:job_arr)
//	    	 {
//	    	for(JobNew obj:jobList)
//	    	 {
//	    		if(job.equals(obj.getJob_id()))
//	    		{
//	    			jobListFinal.add(obj);
//	    			total=total+obj.getPrice();
//	    		}
//	    	 }
//	    	}
//	    }
//	    estimate.setJobs(jobListFinal);
//	    
//	    List<VoiceNew> voice_details= (List<VoiceNew>) voicerepository.findAll();
//	    List<VoiceNew> voice_detailsFinal= new ArrayList<VoiceNew>();
//	    String idStr=String.valueOf(vehicle_id);
//	    
//	    for(VoiceNew voiceobj:voice_details)
//	    	{
//			if(idStr.equals(voiceobj.getVehicle_id()))
//			{
//				voice_detailsFinal.add(voiceobj);
//				total=total+voiceobj.getPrice();
//			}
//	     }
//	    
//	    estimate.setVoice(voice_detailsFinal);
//	    
//	    List<PartsEstimateNew> partsEstimateList=(List<PartsEstimateNew>) partsEstimaterepository.findAll(); 
//		List<String> parts_arr = new ArrayList<String>();
//		for(PartsEstimateNew obj:partsEstimateList)
//    	 {
//			if(String.valueOf(vehicle_id).equals(obj.getVehicle_id()))
//				parts_arr.add(obj.getPart_id());
//    	 }
//		List<PartsNew> partsListFinal = new ArrayList<PartsNew>();
//		List<PartsNew> partsList=(List<PartsNew>) partrepository.findAll();
//		if(parts_arr!=null)
//	    {
//			for(String parts:parts_arr)
//	    	 {
//	    	for(PartsNew obj:partsList)
//	    	 {
//	    		if(parts.equals(obj.getPart_id()))
//	    		{
//	    			partsListFinal.add(obj);
//	    			total=total+obj.getPart_price();
//	    		}
//	    	 }
//	    	}
//	    }
//	    estimate.setParts(partsListFinal);
//	    
//	    estimate.setTotal(total);
//	    return estimate;
		return null;
	}
	
	// insert new customer into database
		@Override
		public String addWithVehicle(Cust_Vin cust_vin)
		{
//			System.out.print("Customer: "+cust_vin);
//			int cust_id= customerrepository.save(cust_vin.getCustomer()).getId();
//			if(cust_id!=0)
//			{
//				cust_vin.getVin().setCustomerID(cust_id);
//				vinRepository.save(cust_vin.getVin());
//			}
			
			return "Success";
		}


		@Override
		public List<CategoryPartsNew> getPartList(String model_id) {
//			List<CategoryPartsNew> partsListFinal = new ArrayList<CategoryPartsNew>();
//			List<ModelNew> modelList=(List<ModelNew>) modelrepository.findAll();
//			List<String> model_arr = new ArrayList<String>();
//			for(ModelNew obj:modelList)
//	    	 {
//				if(String.valueOf(model_id).equals(obj.getModel_id()))
//					model_arr.add(obj.getCat_id());
//	    	 }
//			
//			 List<PartsNew> parts_detailsList= (List<PartsNew>) partrepository.findAll();
//			if(model_arr!=null)
//		    {
//				
//				for(String job:model_arr)
//		    	 {
//				CategoryPartsNew cat_list= new CategoryPartsNew();
//				List<PartsNew> partList = new ArrayList<PartsNew>();	
//				cat_list.setCategory_name(job);
//				for(PartsNew obj:parts_detailsList)
//		    	 {
//		    		if(job.equals(obj.getCat_id()))
//		    		{
//		    			partList.add(obj);
//		    		}
//		    	 }
//				cat_list.setParts(partList);
//				partsListFinal.add(cat_list);
//		    	}
//				
//		    }
//		    return partsListFinal;
			return null;
		}


		@Override
		public List<CategoryNew> getJobList(String model_id) {
			// TODO Auto-generated method stub
			
//			List<CategoryNew> jobListFinal = new ArrayList<CategoryNew>();
//			List<ModelNew> modelList=(List<ModelNew>) modelrepository.findAll();
//			List<String> model_arr = new ArrayList<String>();
//			for(ModelNew obj:modelList)
//	    	 {
//				if(String.valueOf(model_id).equals(obj.getModel_id()))
//					model_arr.add(obj.getCat_id());
//	    	 }
//			
//			 List<JobNew> job_detailsList= (List<JobNew>) jobrepository.findAll();
//			if(model_arr!=null)
//		    {
//				
//				for(String job:model_arr)
//		    	 {
//				CategoryNew cat_list= new CategoryNew();
//				List<JobNew> jobList = new ArrayList<JobNew>();	
//				cat_list.setCategory_name(job);
//				for(JobNew obj:job_detailsList)
//		    	 {
//		    		if(job.equals(obj.getCat_id()))
//		    		{
//		    			jobList.add(obj);
//		    		}
//		    	 }
//				cat_list.setJobs(jobList);
//				jobListFinal.add(cat_list);
//		    	}
//				
//		    }
//		    return jobListFinal;
			return null;
		}


		@Override
		public String addAllEstimate(EstimateSave estimateSave) {
			// TODO Auto-generated method stub
//			System.out.print("estimate: "+estimateSave);
//			List<JobsEstimateNew>jobList=estimateSave.getJobs();
//			List<PartsEstimateNew>partsList=estimateSave.getParts();
//			List<VoiceNew>voiceList=estimateSave.getVoice();
//			jobEstimaterepository.saveAll(jobList);
//			partsEstimaterepository.saveAll(partsList);
//			voicerepository.saveAll(voiceList);
			
			return "Success";
		}

}

package com.research.research.applicationservices.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.garage.dto.VehicelDetailsDTO;
import com.research.research.applicationservices.spi.IWrapperRepositoryNew;
import com.research.research.outputadapters.repositories.CategoryNew;
import com.research.research.outputadapters.repositories.CategoryPartsNew;
import com.research.research.outputadapters.repositories.Cust_Vin;
import com.research.research.outputadapters.repositories.CustomerNew;
import com.research.research.outputadapters.repositories.Estimate;
import com.research.research.outputadapters.repositories.EstimateSave;
import com.research.research.outputadapters.repositories.JobNew;
import com.research.research.outputadapters.repositories.PartsNew;

@Service
public class WrapperServiceNew {
	
	@Autowired
	private IWrapperRepositoryNew wrapperRepository;
	
	public List<CustomerNew> getAllCustomerDataWithAny(String searchStr) {
		// TODO Auto-generated method stub
		return this.wrapperRepository.getAllCustomerDataWithAny(searchStr);
	}

	public Estimate getEstimate(int vehicle_id) {
		// TODO Auto-generated method stub
		return this.wrapperRepository.getEstimate(vehicle_id);
	}

	public String addWithVehicle(Cust_Vin cust_vin) {
		// TODO Auto-generated method stub
		return this.wrapperRepository.addWithVehicle(cust_vin);
	}

	public List<CategoryPartsNew> getPartList(String make_id) {
		// TODO Auto-generated method stub
		return this.wrapperRepository.getPartList(make_id);
	}
	
	public List<CategoryNew> getJobList(String model_id) {
		// TODO Auto-generated method stub
		return this.wrapperRepository.getJobList(model_id);
	}

	public String addAllEstimate(EstimateSave estimateSave) {
		// TODO Auto-generated method stub
		return this.wrapperRepository.addAllEstimate(estimateSave);
	}

}

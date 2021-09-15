package com.research.research.applicationservices.spi;

import java.util.List;

import com.research.garage.dto.VehicelDetailsDTO;
import com.research.research.outputadapters.repositories.CategoryNew;
import com.research.research.outputadapters.repositories.CategoryPartsNew;
import com.research.research.outputadapters.repositories.Cust_Vin;
import com.research.research.outputadapters.repositories.CustomerNew;
import com.research.research.outputadapters.repositories.Estimate;
import com.research.research.outputadapters.repositories.EstimateSave;
import com.research.research.outputadapters.repositories.JobNew;
import com.research.research.outputadapters.repositories.PartsNew;

public interface IWrapperRepositoryNew {
	
	List<CustomerNew> getAllCustomerDataWithAny(String searchStr);

	Estimate getEstimate(int vehicle_id);

	String addWithVehicle(Cust_Vin cust_vin);

	List<CategoryPartsNew> getPartList(String make_id);
	
	List<CategoryNew> getJobList(String make_id);

	String addAllEstimate(EstimateSave estimateSave);
	
}

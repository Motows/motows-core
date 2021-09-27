package com.research.research.applicationservices.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.garage.dto.VehicelDetailsDTO;
import com.research.research.applicationservices.spi.IWrapperRepository;
import com.research.research.inputadapters.web.EstimateDTO;
import com.research.research.outputadapters.repositories.VehicelDetailsListDTO;
import com.research.research.outputadapters.repositories.Vin;

@Service
public class WrapperService {
	
	@Autowired
	private IWrapperRepository wrapperRepository;
	
	public List<VehicelDetailsDTO> getVehicleDetails( String mobileNo){
		return this.wrapperRepository.getVehicleDetails(mobileNo);
		
	}
	public List<VehicelDetailsDTO> getVehicleByCustomer( String mobileNo,String orgId){
		return this.wrapperRepository.getVehicleByCustomer(mobileNo,orgId);
		
	}
	public List<VehicelDetailsDTO> getVehicleByRegNo(String regNo) {
		// TODO Auto-generated method stub
		return this.wrapperRepository.getVehicleByRegNo(regNo);
	}
	public EstimateDTO getEstimateByJobCardID(String jobCardId) {
		// TODO Auto-generated method stub
		return this.wrapperRepository.getEstimateByJobCardID(jobCardId);
	}

}

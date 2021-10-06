package com.research.research.applicationservices.spi;

import java.util.List;

import com.research.garage.dto.VehicelDetailsDTO;
import com.research.research.inputadapters.web.EstimateDTO;
import com.research.research.inputadapters.web.PurchaseDetailsDTO;
import com.research.research.outputadapters.repositories.VehicelDetailsListDTO;
import com.research.research.outputadapters.repositories.Vin;
import com.research.vehicle.entity.VINProjection;

public interface IWrapperRepository {

	List<VehicelDetailsDTO> getVehicleDetails(String mobileNo);

	List<VehicelDetailsDTO> getVehicleByCustomer(String mobileNo,String orgId);

	List<VehicelDetailsDTO> getVehicleByRegNo(String regNo);

	List<VehicelDetailsDTO> getVehicleByRegNo_old(String OrgId, String regNo);

	EstimateDTO getEstimateByJobCardID(String jobCardId);

	List<PurchaseDetailsDTO> getPurchaseDetailsList(String organisation_id, String fromdate, String todate);

	
	
	
	
	
}

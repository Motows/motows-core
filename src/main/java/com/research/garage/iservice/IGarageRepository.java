package com.research.garage.iservice;
import org.springframework.stereotype.Component;

import com.research.garage.dto.GarageDTO;


@Component
public interface IGarageRepository {


	String savegaragedetail(GarageDTO garageDTO);
	GarageDTO getItemsByGarageId(String garageId);
	String deleteGarageById(String garageId);
//
//	
//	CustomerOrderDTO UpdateCustomer(CustomerOrderDTO customerOrderDTO);
//	
	String UpdateGarage(GarageDTO garage);
	
	
}

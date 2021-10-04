package com.research.garage.iservice;

import com.research.garage.dto.LaborDTO;

public interface ILaborRepository {

	String savelaborDetails(LaborDTO labordto);

	LaborDTO getlabordetailsById(String laborId);

	String deleteLaborById(String laborId);

	String UpdateLaborDetails(LaborDTO labordto);

}

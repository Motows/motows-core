package com.research.sparecat.iservice;

import org.springframework.stereotype.Component;

import com.research.sparecat.dto.PartMakeDTO;

@Component
public interface IPartMakeRepository {

	String addPartMake(PartMakeDTO partMakeDTO);
	
	PartMakeDTO getPartMakeById(String partMakeId);
	
	String deletePartMake(String partMakeId);
	
	String updatePartMake(PartMakeDTO partMakeDTO);
}

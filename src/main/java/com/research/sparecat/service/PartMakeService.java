package com.research.sparecat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dto.PartMakeDTO;
import com.research.sparecat.iservice.IPartMakeRepository;

@Component
public class PartMakeService {

	@Autowired
	private IPartMakeRepository partMakeRepository;

	public String addPartMake(PartMakeDTO partMakeDTO) {
		return this.partMakeRepository.addPartMake(partMakeDTO);
	}

	public PartMakeDTO getPartMakeById(String partMakeId) {
		return this.partMakeRepository.getPartMakeById(partMakeId);
	}

	public String deletePartMake(String partMakeId) {
		return this.partMakeRepository.deletePartMake(partMakeId);
	}

	public String updatePartMake(PartMakeDTO partMakeDTO) {
		return this.partMakeRepository.updatePartMake(partMakeDTO);
	}

}

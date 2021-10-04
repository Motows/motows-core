package com.research.garage.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.StateDTO;
import com.research.garage.iservice.IStateRepository;



@Component
public class StateService {

	private final Logger log = LoggerFactory.getLogger(StateService.class);

	@Autowired
	private IStateRepository stateRepository;

	public String addState(StateDTO stateDTO) {

		return this.stateRepository.saveState(stateDTO);

	}

	public StateDTO getStateById(String stateId) {

		return this.stateRepository.getStateById(stateId);

	}

	public String deleteStateById(String stateId) {
		return this.stateRepository.deleteStateById(stateId);
	}

	public String UpdateState(StateDTO stateDTO) {
		return this.stateRepository.UpdateState(stateDTO);
	}

	public List<StateDTO> getAllStates() {
		return this.stateRepository.getAllStates();
	}

}

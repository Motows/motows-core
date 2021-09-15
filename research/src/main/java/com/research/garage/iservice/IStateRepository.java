package com.research.garage.iservice;

import java.util.List;

import org.springframework.stereotype.Component;

import com.research.garage.dto.StateDTO;



@Component
public interface IStateRepository {

	String saveState(StateDTO stateDTO);

	StateDTO getStateById(String stateId);

	String deleteStateById(String stateId);

	String UpdateState(StateDTO stateDTO);

	List<StateDTO> getAllStates();

}

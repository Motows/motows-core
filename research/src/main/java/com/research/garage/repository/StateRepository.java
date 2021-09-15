package com.research.garage.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.CountryDAO;
import com.research.garage.dao.StateDAO;
import com.research.garage.dto.StateDTO;
import com.research.garage.entity.CountryProjection;
import com.research.garage.entity.StateProjection;
import com.research.garage.iservice.IStateRepository;



@Component
public class StateRepository implements IStateRepository {

	@Autowired
	private StateDAO stateDAO;

	@Autowired
	private CountryDAO countryDAO;

	@Override
	public String saveState(StateDTO stateDTO) {
		CountryProjection country = countryDAO.getOne(stateDTO.getCountryId());

		StateProjection state = new StateProjection();
		state.setState_Id(stateDTO.getStateId());
		state.setState_Short_Name(stateDTO.getStateShortName());
		state.setState_Short_Name_Caption(stateDTO.getStateShortNameCaption());
		state.setState_Short_Name_Ui(stateDTO.getStateShortNameUi());
		state.setCountry(country);

		stateDAO.save(state);

		return "State Saved";
	}

	@Override
	public StateDTO getStateById(String stateId) {
		StateProjection state = stateDAO.getOne(stateId);

		StateDTO stateDTO = new StateDTO();

		stateDTO.setStateShortName(state.getState_Short_Name());
		stateDTO.setStateShortNameCaption(state.getState_Short_Name_Caption());
		stateDTO.setStateShortNameUi(state.getState_Short_Name_Ui());
		stateDTO.setStateId(state.getState_Id());

		return stateDTO;
	}

	@Override
	public String deleteStateById(String stateId) {
		stateDAO.deleteById(stateId);
		return "State Deleted";
	}

	@Override
	public String UpdateState(StateDTO stateDTO) {
		StateProjection state = stateDAO.getOne(stateDTO.getStateId());

		state.setState_Short_Name(stateDTO.getStateShortName());
		state.setState_Short_Name_Caption(stateDTO.getStateShortNameCaption());
		state.setState_Short_Name_Ui(stateDTO.getStateShortNameUi());

		return "State Updated";
	}

	@Override
	public List<StateDTO> getAllStates() {
		List<StateProjection> allStates = stateDAO.findAll();
		List<StateDTO> allStateDTO = new ArrayList<StateDTO>();

		for (StateProjection state : allStates) {

			StateDTO stateDTO = new StateDTO();

			stateDTO.setStateShortName(state.getState_Short_Name());
			stateDTO.setStateShortNameCaption(state.getState_Short_Name_Caption());
			stateDTO.setStateShortNameUi(state.getState_Short_Name_Ui());
			stateDTO.setStateId(state.getState_Id());
			allStateDTO.add(stateDTO);

		}

		return allStateDTO;
	}

}

package com.research.garage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.dto.StateDTO;

import com.research.garage.service.StateService;

@RestController
@RequestMapping("api/state")
public class StateController {
	
	
	@Autowired
	private StateService stateService;
	
	@PostMapping("/addState")
    public String addState(@RequestBody StateDTO stateDTO){
    	return this.stateService.addState(stateDTO);
    }
	
	@GetMapping("/getState/{stateId}")
	public StateDTO getStateByCustomerId(@PathVariable("stateId") String stateId) {
		
		return this.stateService.getStateById(stateId);
	}
	@DeleteMapping("/deleteCountryById/{stateId}")
	public String deleteStateId(@PathVariable("stateId") String stateId) {
		
		return this.stateService.deleteStateById(stateId);
	}
	@PostMapping("/updateState")
	public String UpdateState(@RequestBody StateDTO stateDTO) {
		return this.stateService.UpdateState(stateDTO);
	}
	
	@GetMapping("/getState")
	public List<StateDTO> getAllStates(){
		return this.stateService.getAllStates();
		
	}
	

}

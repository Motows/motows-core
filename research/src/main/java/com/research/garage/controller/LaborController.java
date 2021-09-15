package com.research.garage.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.dto.LaborDTO;
import com.research.garage.service.LaborDetailsService;;

@RestController
@RequestMapping("api/Labor")
public class LaborController {

	@Autowired
	private LaborDetailsService LaborDetailsService;
	
	@PostMapping("/addLabordetails")
    public String addlabordetails(@RequestBody LaborDTO labordto){
    	return this.LaborDetailsService.addlabordetails(labordto);
    }
	
	@GetMapping("/getLabordetails/{LaborId}")
	public LaborDTO getlabordetailsById(@PathVariable("LaborId") String laborId) {
		
		return this.LaborDetailsService.getlabordetailsById(laborId);
	}
	@DeleteMapping("/deleteById/{LaborId}")
	public String deleteLaborById(@PathVariable("LaborId") String laborId) {
		
		return this.LaborDetailsService.deleteLaborById(laborId);
	}
	@PutMapping("/updateLaborDetails")
	public String UpdateLaborDetails(@RequestBody LaborDTO labordto) {
		return this.LaborDetailsService.UpdateLaborDetails(labordto);
	}
	
	
}

package com.research.garage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.dto.OrganisationDTO;

import com.research.garage.service.OrganisationService;

import io.swagger.annotations.Api;
@Api(description = "Organizataion Controller", tags = { "Garage Organizataion" })
@RestController
@RequestMapping("api/organisation")
public class GGOrganisationController {

	@Autowired
	private OrganisationService OrganisationService;
	
	@PostMapping("/addorganisation")
    public String addOrganisation(@RequestBody OrganisationDTO orgnisation){
    	return this.OrganisationService.addOrganisation(orgnisation);
    }
	
	@GetMapping("/getOrganisation/{OrganisationId}")
	public OrganisationDTO getOrganisationById(@PathVariable("OrganisationId") String organisationId) {
		
		return this.OrganisationService.getOrganisationById(organisationId);
	}
	@DeleteMapping("/deleteById/{OrganisationId}")
	public String deleteOrganisationById(@PathVariable("OrganisationId") String organisationId) {
		
		return this.OrganisationService.deleteOrganisationById(organisationId);
	}
	@PostMapping("/updateOrganisation")
	public String UpdateOrganisation(@RequestBody OrganisationDTO orgnisation) {
		return this.OrganisationService.UpdateOrganisation(orgnisation);
	}
	
	
}

package com.research.garage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.OrganisationDTO;
import com.research.garage.iservice.IOrganisationRepository;



@Component
public class OrganisationService {

	private final Logger log = LoggerFactory.getLogger(OrganisationService.class);
	
	@Autowired
	private IOrganisationRepository organisationRepository;
	
	
	public String addOrganisation(OrganisationDTO organisationDTO) {

		return this.organisationRepository.saveOrganisation(organisationDTO);

	}

	public OrganisationDTO getOrganisationById(String organisationId) {

		return this.organisationRepository.getOrganisationById(organisationId);

	}
	public String deleteOrganisationById(String organisationId) {
		return this.organisationRepository.deleteOrganisationById(organisationId);
	}

	public String UpdateOrganisation(OrganisationDTO organisationDTO) {
	return	this.organisationRepository.UpdateOrganisation(organisationDTO);
	}
	
	
}

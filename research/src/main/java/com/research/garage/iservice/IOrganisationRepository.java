package com.research.garage.iservice;

import org.springframework.stereotype.Component;

import com.research.garage.dto.OrganisationDTO;



@Component
public interface IOrganisationRepository {

	String saveOrganisation(OrganisationDTO organisationDTO);
	OrganisationDTO getOrganisationById(String organisationId);
	
	String deleteOrganisationById(String organisationId);

	
	String UpdateOrganisation(OrganisationDTO organisationDTO);
	
}

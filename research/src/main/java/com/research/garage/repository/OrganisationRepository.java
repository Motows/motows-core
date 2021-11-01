package com.research.garage.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.OrganisationDTO;
import com.research.garage.dao.CountryDAO;
import com.research.garage.dao.OrganisationDAO;
import com.research.garage.entity.CountryProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.garage.iservice.IOrganisationRepository;



@Component
public class OrganisationRepository implements IOrganisationRepository {

	@Autowired
	private OrganisationDAO  OrganisationDAO;
	
	@Autowired
	private CountryDAO countryDAO;
	
	
	@Override
	public String saveOrganisation(OrganisationDTO organisationDTO) {
		
		CountryProjection country = countryDAO.getOne(organisationDTO.getCountryId());
		
		if(country==null)
		{
			return "Country ID "+ organisationDTO.getCountryId() +" not in the Master";
		}
		
		OrganisationProjection org = new OrganisationProjection();
		
		org.setOrganisation_Name(organisationDTO.getOrganisationName());
		org.setOrganisationUI(organisationDTO.getOrganisationUI());
		org.setPANNo(organisationDTO.getPANNo());
		org.setOrganisation_Caption(organisationDTO.getOrganisationCaption());
		org.setTanentID(organisationDTO.getTanentID());
		
		org.setCountryID(organisationDTO.getCountryId());
		OrganisationDAO.save(org);

		return "Organisation Saved";
	}

	@Override
	public OrganisationDTO getOrganisationById(String organisationId) {
		
		OrganisationProjection org =	OrganisationDAO.getOne(organisationId);
		
		OrganisationDTO response = new OrganisationDTO();
		
		response.setOrganisationName(org.getOrganisation_Name());
		response.setOrganisationUI(org.getOrganisationUI());
		response.setOrganisationCaption(org.getOrganisation_Caption());
		response.setPANNo(org.getPANNo());
		response.setTanentID(org.getTanentID());
		response.setOrgID(org.getOrgID());
		response.setCountryId(org.getCountryID());
	
		return response;
	}

	@Override
	public String deleteOrganisationById(String organisationId) {
		
		if(OrganisationDAO.getOne(organisationId)!=null)
		{
			
			OrganisationDAO.deleteById(organisationId);
			
			return "Organisation deleted";
		}
		else
		{
			return "Organisation id Not found";
		}
	
	}

	@Override
	public String UpdateOrganisation(OrganisationDTO organisationDTO) {
CountryProjection country = countryDAO.getOne(organisationDTO.getCountryId());
		
		if(country==null)
		{
			return "Country ID "+ organisationDTO.getCountryId() +" not in the Master";
		}
		
		OrganisationProjection org =	OrganisationDAO.getOne(organisationDTO.getOrgID());
		
		org.setOrganisation_Name(organisationDTO.getOrganisationName());
		org.setOrganisationUI(organisationDTO.getOrganisationUI());
		org.setOrganisation_Caption(organisationDTO.getOrganisationCaption());
		org.setPANNo(organisationDTO.getPANNo());
		org.setTanentID(organisationDTO.getTanentID());
		org.setCountryID(organisationDTO.getCountryId());
		OrganisationDAO.save(org);
		
		return "updated";
	}

}

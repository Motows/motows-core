package com.research.garage.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.CountryDAO;
import com.research.garage.dao.GarageDAO;
import com.research.garage.dto.GarageDTO;
import com.research.garage.dao.OrganisationDAO;
import com.research.garage.entity.CountryProjection;
import com.research.garage.entity.GarageProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.garage.iservice.IGarageRepository;




@Component
public class GarageDAOReposiory implements IGarageRepository {

	@Autowired
	private GarageDAO garageDAO;
	

	@Autowired
	private CountryDAO countryDAO;
	
	@Autowired
	private OrganisationDAO OrganisationDAO;
	

	@Override
	public String savegaragedetail(GarageDTO garageDTO) {
		
		OrganisationProjection org = OrganisationDAO.getOne(garageDTO.getOrgId());
		// TODO Auto-generated method stub
		if(org==null)
		{
			return "Organisation ID "+ garageDTO.getOrgId() +" not in the Master";
		}
		
		CountryProjection country = countryDAO.getOne(garageDTO.getCountryID());
		if(country==null)
		{
			return "Country ID "+ garageDTO.getCountryID() +" not in the Master";
		}
		GarageProjection garagepro = new GarageProjection();
		garagepro.setAddress(garageDTO.getAddress());
		garagepro.setCurrency(garageDTO.getCurrency());
		garagepro.setGSTIN_NO(garageDTO.getGSTIN_NO());
		garagepro.setGeo_Location(garageDTO.getGeoLocation());
		garagepro.setState(garageDTO.getState());
		garagepro.setGarage_Caption(garageDTO.getGarageCaption());
		garagepro.setGarage_Name(garageDTO.getGarageName());
		garagepro.setCountryID(garageDTO.getCountryID());
		garagepro.setOrg_Id(garageDTO.getOrgId());
		garageDAO.save(garagepro);
		return "GarageDetails Saved";

		
	
	}

	@Override
	public GarageDTO getItemsByGarageId(String garageId) {
		
		
		GarageProjection grp =	garageDAO.getOne(garageId);
		
		GarageDTO crDto = new GarageDTO();
		
		crDto.setGarageId(grp.getGarage_Id());
		crDto.setAddress(grp.getAddress());
		crDto.setCurrency(grp.getCurrency());
		crDto.setGSTIN_NO(grp.getGSTIN_NO());
		crDto.setGeoLocation(grp.getGeo_Location());
		crDto.setState(grp.getState());
		crDto.setGarageCaption(grp.getGarage_Caption());
		crDto.setGarageName(grp.getGarage_Name());
		crDto.setOrgId(grp.getOrg_Id());
		crDto.setCountryID(grp.getCountryID());
		return crDto;
		
	}


	@Override
	public String deleteGarageById(String garageId) {	
		
		garageDAO.deleteGarageById(garageId);
		
		
		
		return "deleted";
	}
	
	@Override
	public String UpdateGarage(GarageDTO garage) {
		OrganisationProjection org = OrganisationDAO.getOne(garage.getOrgId());
		// TODO Auto-generated method stub
		if(org==null)
		{
			return "Organisation ID "+ garage.getOrgId() +" not in the Master";
		}
		
		CountryProjection country = countryDAO.getOne(garage.getCountryID());
		if(country==null)
		{
			return "Country ID "+ garage.getCountryID() +" not in the Master";
		}
		GarageProjection grg = garageDAO.getOne(garage.getGarageId());


		grg.setAddress(garage.getAddress());
		grg.setCurrency(garage.getCurrency());
		grg.setGSTIN_NO(garage.getGSTIN_NO());
		grg.setGeo_Location(garage.getGeoLocation());
		grg.setState(garage.getState());
		grg.setGarage_Caption(garage.getGarageCaption());
		grg.setGarage_Name(garage.getGarageName());
		grg.setOrg_Id(garage.getOrgId());
		grg.setCountryID(garage.getCountryID());

		garageDAO.save(grg);

		return "updated";
	}
	
	

}

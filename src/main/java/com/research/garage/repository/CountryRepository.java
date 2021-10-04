package com.research.garage.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.CountryDAO;
import com.research.garage.dto.CountryDTO;
import com.research.garage.entity.CountryProjection;
import com.research.garage.iservice.ICountryRepository;



@Component
public class CountryRepository implements ICountryRepository {

	@Autowired
	private CountryDAO countryDAO;

	@Override
	public String saveCountry(CountryDTO countryDTO) {

		CountryProjection country = new CountryProjection();
		String countryId=countryDTO.getCountryID();
		if(countryId==null || countryId.isEmpty())
		{
			return "Country ID Required";
		}
		if(countryDAO.getOne(countryId)!=null)
		{
			return "Country ID Already Available";
		}
		country.setCountryID(countryDTO.getCountryID());
		country.setCountry_Long_Name(countryDTO.getCountryLongName());
		country.setCountry_Long_Name_Caption(countryDTO.getCountryLongNameCaption());
		country.setCountry_Long_NameUI(countryDTO.getCountryLongNameUI());
		country.setCountry_Short_Name(countryDTO.getCountryShortName());
		country.setCountry_Short_Name_Caption(countryDTO.getCountryShortNameCaption());
		country.setCountry_Short_NameUI(countryDTO.getCountryShortNameUI());

		countryDAO.save(country);

		return "Country Saved";
	}

	@Override
	public CountryDTO getCountryById(String countryionId) {
		CountryProjection country = countryDAO.getOne(countryionId);

		CountryDTO countryDTO = new CountryDTO();

		countryDTO.setCountryLongName(country.getCountry_Long_Name());
		countryDTO.setCountryLongNameCaption(country.getCountry_Long_Name_Caption());
		countryDTO.setCountryLongNameUI(country.getCountry_Long_NameUI());
		countryDTO.setCountryShortName(country.getCountry_Short_Name());
		countryDTO.setCountryShortNameCaption(country.getCountry_Short_Name_Caption());
		countryDTO.setCountryShortNameUI(country.getCountry_Short_NameUI());

		return countryDTO;
	}

	@Override
	public String deleteCountryById(String countryionId) {

		countryDAO.deleteById(countryionId);

		return "Country Deleted";
	}

	@Override
	public String UpdateCountry(CountryDTO countryDTO) {
		CountryProjection country = countryDAO.getOne(countryDTO.getCountryID());

		country.setCountry_Long_Name(countryDTO.getCountryLongName());
		country.setCountry_Long_Name_Caption(countryDTO.getCountryLongNameCaption());
		country.setCountry_Long_NameUI(countryDTO.getCountryLongNameUI());
		country.setCountry_Short_Name(countryDTO.getCountryShortName());
		country.setCountry_Short_Name_Caption(countryDTO.getCountryShortNameCaption());
		country.setCountry_Short_NameUI(countryDTO.getCountryShortNameUI());

		countryDAO.save(country);

		return "Country Updated";
	}

	@Override
	public List<CountryDTO> getAllCountries() {
		List<CountryProjection> allCountories = countryDAO.findAll();

		List<CountryDTO> allCountriesDTO = new ArrayList<CountryDTO>();

		for (CountryProjection country : allCountories) {

			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCountryID(country.getCountryID());
			countryDTO.setCountryLongName(country.getCountry_Long_Name());
			countryDTO.setCountryLongNameCaption(country.getCountry_Long_Name_Caption());
			countryDTO.setCountryLongNameUI(country.getCountry_Long_NameUI());
			countryDTO.setCountryShortName(country.getCountry_Short_Name());
			countryDTO.setCountryShortNameCaption(country.getCountry_Short_Name_Caption());
			countryDTO.setCountryShortNameUI(country.getCountry_Short_NameUI());

			allCountriesDTO.add(countryDTO);

		}

		return allCountriesDTO;

	}
}

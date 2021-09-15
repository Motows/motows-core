package com.research.garage.iservice;

import java.util.List;

import org.springframework.stereotype.Component;

import com.research.garage.dto.CountryDTO;



@Component

public interface ICountryRepository {

	String saveCountry(CountryDTO countryDTO);
	CountryDTO getCountryById(String countryId);
	
	public List<CountryDTO> getAllCountries ();
	
	 String deleteCountryById(String countryId);

	
	String UpdateCountry(CountryDTO countryDTO);
	
}

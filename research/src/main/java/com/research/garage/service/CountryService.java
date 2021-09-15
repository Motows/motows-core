package com.research.garage.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.CountryDTO;
import com.research.garage.iservice.ICountryRepository;



@Component
public class CountryService {
	
	private final Logger log = LoggerFactory.getLogger(CountryService.class);
	
	@Autowired
	private ICountryRepository countryRepository;
	
	public String addCountry(CountryDTO countryDTO) {

		return this.countryRepository.saveCountry(countryDTO);

	}

	public CountryDTO getCountryId(String countryId) {

		return this.countryRepository.getCountryById(countryId);

	}
	public String deleteCountryById(String countryId) {
		return this.countryRepository.deleteCountryById(countryId);
	}

	public String UpdateCountry(CountryDTO countryDTO) {
	return	this.countryRepository.UpdateCountry(countryDTO);
	}
	public List<CountryDTO> getAllCountries() {
		return this.countryRepository.getAllCountries();
		
	}
	

}

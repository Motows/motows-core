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

import com.research.garage.dto.CountryDTO;
import com.research.garage.service.CountryService;

import io.swagger.annotations.Api;

@Api(value = "Garage Country", description = "Country Controller", tags = { "Garage Country" })
@RestController
@RequestMapping("api/country")
public class GGCountryController {

	@Autowired
	private CountryService countryService;
	
	@PostMapping("/addcountry")
    public String addCountry(@RequestBody CountryDTO countryDTO){
    	return this.countryService.addCountry(countryDTO);
    }
	
	@GetMapping("/getCountry/{countryId}")
	public CountryDTO getCountryByCountryId(@PathVariable("countryId") String countryId) {
		
		return this.countryService.getCountryId(countryId);
	}
	

	@DeleteMapping("/deleteCountryById/{countryId}")
	public String deleteCountryByCountryId(@PathVariable("countryId") String countryId) {
		
		return this.countryService.deleteCountryById(countryId);
	}
	@PostMapping("/updateCountry")
	public String UpdateCountry(@RequestBody CountryDTO countryDTO) {
		return this.countryService.UpdateCountry(countryDTO);
	}
	
	@GetMapping("/getCountry")
	public List<CountryDTO> getAllCountries (){
		
		return this.countryService.getAllCountries();
	}
	
}

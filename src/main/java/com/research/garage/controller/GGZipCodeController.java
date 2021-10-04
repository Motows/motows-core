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

import com.research.garage.dto.ZipCodeDTO;
import com.research.garage.service.ZipCodeService;

import io.swagger.annotations.Api;


@Api(description = "Zip Code Controller", tags = { "Garage Zip Code" })
@RestController
@RequestMapping("api/zipcode")
public class GGZipCodeController {

	@Autowired
	private ZipCodeService zipCodeService;

	@PostMapping("/addZipCode")
	public String saveZipCode(@RequestBody ZipCodeDTO ZipCodeDTO) {

		return this.zipCodeService.saveZipCode(ZipCodeDTO);
	}

	@GetMapping("/getZipCode/{ZipCodeId}")
	public ZipCodeDTO getZipCodeById(@PathVariable String ZipCodeId) {

		return this.zipCodeService.getZipCodeById(ZipCodeId);
	}

	@DeleteMapping("/deleteZipCodeById/{ZipCodeId}")
	public String deleteZipCodeById(@PathVariable String ZipCodeId) {

		return this.zipCodeService.deleteZipCodeById(ZipCodeId);
	}

	@PostMapping("/updateZipCode")
	public String UpdateZipCode(@RequestBody ZipCodeDTO ZipCodeDTO) {

		return this.zipCodeService.UpdateZipCode(ZipCodeDTO);
	}

	@GetMapping("/getZipCode")
	public List<ZipCodeDTO> getAllZipCodes() {
		return this.zipCodeService.getAllZipCodes();
	}
	
	@GetMapping("/getListForCountry/{countryID}")
	public List<ZipCodeDTO> getListForCountry(@PathVariable String countryID) {
		return this.zipCodeService.getListForCountry(countryID);
	}

}

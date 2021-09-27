package com.research.garage.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.dto.GarageDTO;
import com.research.garage.service.GarageService;

import io.swagger.annotations.Api;


@Api(description = "Garage Controller", tags = { "Garage" })
	@RestController
	@RequestMapping("api/Garage")
	public class GGGarageController {

		@Autowired
		private GarageService garageService;
		
		@PostMapping("/addgaragedetails")
	    public String addGarage(@RequestBody GarageDTO GarageDetails){
	    	return garageService.addGarage(GarageDetails);
	    }
		
		@GetMapping("/getItems/{GarageId}")
		public GarageDTO getGarageById(@PathVariable("GarageId") String garageId) {
			
			return garageService.getItemsByGarageId(garageId);
		}
		@DeleteMapping("/deleteById/{GarageId}")
		public String deleteItemsByGarageId(@PathVariable("GarageId") String garageId) {
			
			return this.garageService.deleteGarageById(garageId);
		}	
		@PutMapping("/updateGarage")
		public String UpdateGarage(@RequestBody GarageDTO garage) {
			return this.garageService.UpdateGarage(garage);
		}
		
}
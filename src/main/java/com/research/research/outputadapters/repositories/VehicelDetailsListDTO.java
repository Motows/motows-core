package com.research.research.outputadapters.repositories;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class VehicelDetailsListDTO {
	
	
	List<Vin> vin = new ArrayList<>();

	public List<Vin> getVin() {
		return vin;
	}

	public void setVin(List<Vin> vin) {
		this.vin = vin;
	}



}

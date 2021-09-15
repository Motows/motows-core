package com.research.garage.dto;

import com.research.vehicle.entity.ColorProjection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicelDetailsDTO {
	
	
	private String ManufactureYear;

	private String ColorDesc;
	
	private String ModelDesc;
	
	private String VehicleNumber;

}

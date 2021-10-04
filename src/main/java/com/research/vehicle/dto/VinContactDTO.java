package com.research.vehicle.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class VinContactDTO {
	
	private String VehicleID; 
	
	private String CustomerID;

	private String ContactType;
}

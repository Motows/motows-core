package com.research.garage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class ZipCodeDTO {
	
	private String zipCodeId;
	
	private String countryId;
	
	
	private String stateId;
	
	
	private String cityName;
	
	
}

package com.research.garage.dto;

import java.util.List;

import com.research.garage.entity.ZipCodeProjection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class StateDTO {

	private String stateId;
	
	
	private String countryId;

	private String stateShortName;

	private String stateShortNameCaption;

	private String stateShortNameUi;
	
	
	
	
}

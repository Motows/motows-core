package com.research.garage.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class OrganisationDTO {

	private String OrgID;
	
	private String OrganisationName;
	
	private String OrganisationCaption;
	
	private String OrganisationUI;
	
	private String TanentID;

	private String PANNo;
	
//	private List<CountryProjection> country;
	
	private String countryId;
	
}

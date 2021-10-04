package com.research.garage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class GarageDTO {
	
	 	private String garageId;

	    private String garageName;
	   
	    private String garageCaption;
	    
	    private String State;
	   
	    private String Address;
	   
	    private String GSTIN_NO;
	   
		private String Currency;
	    
	    private String GeoLocation;
	    
	    private String orgId;
	    
	    private String CountryID;
	    
	  

		

}





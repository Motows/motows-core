package com.research.garage.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class VendorDTO {

	private String VendorID; 
	
	private String VendorName;
	
	private String VendorNameCaption;
	
	private String VendorNameUI;
	 
	private String Type;
	
	private String EmailID;
	
	private String Address;
	
	private String MobileNo;

	private String MobileNoVerified;
	
	private String EmailIDVerified;
	
	private String GSTIN;
	
	private String orgId;
	
	private String countryId;
	
	private String stateId;
	
	private String zipCodeId;
	
}


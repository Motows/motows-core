package com.research.research.applicationservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class CustomerDTONew {

	private String customerId;

	private String customerName;

	private String customerNameCaption;

	private String customerNameUi;
	
	
	private String organisationId;
	
	
	private String type;
	
	private String emailId;

	private String address;
	
 
	private String countryId;
	

	private String stateId;
		
	private String zipCodeId;
	
	
	private String mobileNo;
	
	private String mobileNoVerified;
	
	private String emailIdVerified;
	
	
	private String gstIn;
	
	
}
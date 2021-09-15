package com.research.vehicle.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class VINDTO {
	private String VehicleID; 

	private String VINRegNo;
	
	private String VINNo;
	
	private String ModelID;
	
	private String ManufactureYear;
	
	private String ColorID;
	
	private String VehicleNotes;
	
	private String CustomerId;
	
	private String ContactType;
	
	private String OrgId;
}

package com.research.garage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class EmployeeDTO {

	private String employeeId;
	
	private String employeeName;
	
	private String organisationId;
	
	private String mobileNo;
	
	private String emailId;

	private String Role;

	private String status;
	
}
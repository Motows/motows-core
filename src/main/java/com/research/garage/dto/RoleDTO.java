package com.research.garage.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class RoleDTO {

	private String RoleId; 
	
	private String RoleName;
	
	private String RoleCaption;
	
	private String RoleUI;
	
}

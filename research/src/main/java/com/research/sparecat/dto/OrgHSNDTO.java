package com.research.sparecat.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class OrgHSNDTO {
	private String HSNCode;

	private String OrganisationID;

	private String Description;

	private String Type;
	
}

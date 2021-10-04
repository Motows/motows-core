package com.research.sparecat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrgModelDTO {

	private String ModelID;

	private String OrganisationID;

	private String PartID;

	private String ModelDescription;

	private String ModelCaption;

	private String ModelUI;

}

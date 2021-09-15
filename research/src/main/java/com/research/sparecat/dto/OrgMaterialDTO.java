package com.research.sparecat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrgMaterialDTO {

	private String PartID;

	private String PartMake;

	private String OrganisationID;

	private String PartDescription;

	private String PartsCaption;

	private String PartsUI;

	private String Category;

	private String HSN;

	private String SalesPrice;

}

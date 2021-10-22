package com.research.sparecat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDTO {

	private String PartID;

	private String PartMake;

	private String PartDescription;

	private String PartsCaption;

	private String PartsUI;

	private String Category;

	private String HSN;

	private String SalesPrice;
	//private String OrganizationID;
}

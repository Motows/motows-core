package com.research.sparecat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PartMakeDTO {
	
	
	private String partMakeId;

	private String partMakeName;
	private String partsMakeCaption;

	private String partsMakeUi;
}

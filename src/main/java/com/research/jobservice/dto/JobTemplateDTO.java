package com.research.jobservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class JobTemplateDTO {
	private String jobTemplateId;
	
	private String jobTemplateDiscription;
	
	private String jobTemplateCaption;
	
	private String jobTempUi;
	
	private String modelId;
	
	private String organisationId;

	private String garageId;
	
	private String Category;
	private int Price;

}

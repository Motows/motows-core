package com.research.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelDTO {

	private String modelId;

	private String partId;

	private String modelDescription;

	private String modelCaption;

	private String modelUi;

	private String bodyType;

}

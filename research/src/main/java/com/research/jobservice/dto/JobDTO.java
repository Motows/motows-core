package com.research.jobservice.dto;
import javax.persistence.Column;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class JobDTO {
	private String JobID;
	private String OrganisationID;	
	private String Garageid;
	private String JobCardID;
	private String Job_Description;
	private int Price;
	private String jobStatus;
}	

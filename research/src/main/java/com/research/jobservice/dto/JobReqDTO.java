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
public class JobReqDTO {
	private String Job_Description;
	private int Price;
	private String jobStatus;
	private String Jobtype;
	private String Garageid;
}

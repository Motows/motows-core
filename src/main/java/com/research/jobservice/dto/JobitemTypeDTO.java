package com.research.jobservice.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
public class JobitemTypeDTO {
	private String jobitemtypeID;

	
	private String JobItemName;

	
	private String jobItemUI;


	private String jobItemCaption;

}

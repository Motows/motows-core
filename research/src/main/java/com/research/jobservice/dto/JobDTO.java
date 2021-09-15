package com.research.jobservice.dto;
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
    
    private String JobDescription;
    
    private String JobDescriptionCaption;
    
    private String OrganisationID;
    
    private String JobDescriptionUI;
    
    private String Model;
}	

package com.research.jobservice.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class JobSearchDTO {

	
    private String JobDescription;
    private String OrganisationID;
    private String Model;
    private String Category;
}	

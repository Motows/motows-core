package com.research.garage.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class LaborDTO {
	private String LaborID;
   
    private String LaborDescription;
   
    private String LaborDescriptionCaption;
    
    private String LaborDescriptionUI;
    
    private String OrganisationID;
   
    private String HSN;

}

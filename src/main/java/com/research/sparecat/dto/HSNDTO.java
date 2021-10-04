package com.research.sparecat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class HSNDTO {
	
    private String HSNCode;
   
    private String Description;
   
    private String Type;
}

package com.research.finance.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class PaymentDTO {
	
    private String PaymentID;
    
	private Date Date;
   
    private String Entrytype;
    
    private String OrganisationID;
   
    private String GarageID;
   
    private String Payment_Amount;
  
    private String PaymentVia;
}

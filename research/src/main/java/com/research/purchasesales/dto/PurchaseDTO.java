package com.research.purchasesales.dto;
import java.util.Date;
import java.util.List;

//github.com/ikyamResearch2/Research.git

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class PurchaseDTO {
	
	private String PurcahseID;
	
	private String EntryType;
	 
	private String OrganisationID;

	private String GarageID;
	
	private Date EntryDate;
   
    private String VendorID;
   
    private String Supplierrefno;
   
    private Date SupplierrefPostingDate;
  
    private String Jobno;
    
    private List<PurchaseLineDTO> Purchaseline;
    
}

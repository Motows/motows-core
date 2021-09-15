package com.research.purchasesales.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class InventoryDTO {
	private String Entryno;
	 
	private String orgId;
	 
	private String GarageID;
		
	private Date EntryDate;

	private String ItemCode;

	private String stockin;

	private String stockout; 

	private String purprices;

   private String salesprice;
  
   private String referencetransaction;


}
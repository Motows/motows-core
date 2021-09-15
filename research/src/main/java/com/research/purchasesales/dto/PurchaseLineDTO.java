package com.research.purchasesales.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor

public class PurchaseLineDTO {

	private String PurcahseLineId; 
	
	private String Purchaselineno;

	private String Itemcode;

	private String Qty;

	private String Uom;

	private String Price;

	private String Tax;
	
	private String HSN;
	
	
	
}

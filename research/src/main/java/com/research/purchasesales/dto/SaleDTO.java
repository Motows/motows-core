package com.research.purchasesales.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class SaleDTO {

	private String salesId;
	

	private String entryType;
	

	private String organisationId;
	
	
	private String garageId;
	
	
	private String customerId;
	
	private Date entryDate;
	
	
	private String JobNo;
	
//	private List<SalesLineDTO> salesLIne;
	
}

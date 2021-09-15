package com.research.purchasesales.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class SalesLineDTO {

	

	private String salesLineNo;

	private String itemcode;

	private Long qty;

	private Long Uom;

	private Double Price;

	private Double Tax;

	private String hsnOrSac;

}

package com.research.jobservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
public class JobItemsDTO {

	private String jobItemId;

	private String jobNo;

	private String jobItemType;

	private String itemcode;

	private Double qty;

	private Long uom;

	private Double Price;

	private Double Tax;

	private String hsnAndSac;
	private String job_cardid;
	private String item_status;

}

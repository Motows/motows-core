package com.research.finance.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceiptDTO {

	private String receiptId;

	private Date date;

	private String EntryType;

	private String organisationId;

	private String garageId;

	private String jobCardId;

	private Double receiptAmount;

	private String receiptVia;
}

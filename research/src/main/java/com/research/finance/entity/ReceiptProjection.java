package com.research.finance.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Receipt")
@Table(name = "Receipt")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptProjection {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo_sql")
	@GenericGenerator(name = "demo_sql", strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator", parameters = {

			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "REC_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER, value = "%05d"), })
	@Id
	@Column(length = 50)
	private String receipt_Id;

	private Date date;
	@Column(length = 50)
	private String Entry_Type;

	@Column(length = 50)
	private String organisation_Id;
	@Column(length = 50)
	private String garage_Id;
	@Column(length = 50)
	private String job_Card_Id;
	private Double receipt_Amount;
	@Column(length = 50)
	private String receipt_Via;

}

package com.research.purchasesales.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;
@Entity(name = "SalesLine")
@Table(name = "SalesLine")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalesLineProjection  {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo_sql")
	@GenericGenerator(name = "demo_sql", strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator", parameters = {

			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "Sal_Li_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER, value = "%05d"),

	})
	@Id
	@Column(unique = true,length = 50)
	private String sales_Line_No;

	@Column(length = 50)
	private String itemcode;

	private Long qty;

	private Long Uom;

	private Double Price;

	private Double Tax;

	@Column(length = 50)
	private String hsn_Or_Sac;
	
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "sales_Id")
	private SaleProjection sale;

}

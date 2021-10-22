package com.research.purchasesales.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;
@Entity(name = "Sales")
@Table(name = "Sales")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SaleProjection {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo_sql")
	@GenericGenerator(name = "demo_sql", strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator", parameters = {

			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "Sal_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER, value = "%05d"),

	})
	@Id
	@Column(unique = true, length = 50)
	private String sales_Id;

	@Column(length = 50)
	private String entry_Type;

	@Column(length = 50)
	private String organisation_Id;

	@Column(length = 50)
	private String garage_Id;

	@Column(length = 50)

	private String customer_Id;

	@CreatedDate
	private Date entry_Date;

	@Column(length = 50)
	private String Job_No;

//	@OneToMany(targetEntity = SalesLineProjection.class, cascade = { CascadeType.DETACH, CascadeType.MERGE,
//			CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE }, mappedBy = "sale")
//	@ToString.Exclude
//	private List<SalesLineProjection> salesLine;
//
//	public void add(SalesLineProjection theSalesLines) {
//		if (salesLine == null) {
//			salesLine = new ArrayList<SalesLineProjection>();
//		}
//		salesLine.add(theSalesLines);
//		theSalesLines.setSale(this);
//
//	}
}

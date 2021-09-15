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
import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;
@Entity(name = "PurcahseLine")
@Table(name = "PurcahseLine")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseLineProjection {
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "demo_sql")
	@GenericGenerator(name = "demo_sql",strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator",parameters = {
			
			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM,value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER,value = "PRL_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER,value = "%05d"),
			
			
			
	} )
	@Id
	@Column(unique=true, length = 50)
	private String Purcahse_Line_Id; 
	@Column(length = 150)
	private String Purchaselineno;
	@Column(length = 150)
	private String Itemcode;
	@Column(length = 150)
	private String Qty;
	@Column(length = 150)
	private String Uom;
	@Column(length = 150)
	private String Price;
	@Column(length = 150)
	private String Tax;
	@Column(length = 150)
	private String HSN;
	 @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinColumn(name="PurcahseID")
		private PurchaseProjection Purchase;
}

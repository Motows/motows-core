package com.research.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Brand")
@Table(name = "Brand")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandProjection {

	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "demo_sql")
	@GenericGenerator(name = "demo_sql",strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator",parameters = {
			
			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM,value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER,value = "BRD_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER,value = "%05d"),
	} )
	@Id
	@Column(updatable = false, nullable = false, length = 50)
	private String brand_Id;
	
	@Column(length = 50)
	private String brand_Name;
	
	@Column(length = 50)
	private String brand_Caption;
	
	@Column(length = 50)
	private String brand_Ui;

	
	
}

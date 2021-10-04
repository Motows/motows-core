package com.research.vehicle.entity;

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

import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Color")
@Table(name = "Color")
@EntityListeners(EntityListeners.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ColorProjection {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "demo_sql")
	@GenericGenerator(name = "demo_sql",strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator",parameters = {
			
			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM,value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER,value = "CLR_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER,value = "%05d"),
	} )
	@Id
@Column(updatable = false, nullable = false, length = 50)
	private String color_Id;
	 
	@Column(length = 50)
	private String color_Description;
//	@OneToOne(mappedBy = "Color")
	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "Color")
	private List<VINProjection> vin;

}

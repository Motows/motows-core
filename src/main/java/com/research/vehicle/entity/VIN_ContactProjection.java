package com.research.vehicle.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.research.garage.entity.CustomerProjection;
import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "VIN_Contact")
@Table(name = "VIN_Contact")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VIN_ContactProjection {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo_sql")
	@GenericGenerator(name = "demo_sql", strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator", parameters = {

			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "VIN_Contact"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER, value = "%05d"),

	})
	@Id
	@Column(unique = true, length = 50)
	private String VehicleID;
//	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinColumn(name = "customerId")
//	private CustomerProjection customer;
	@Column(length = 100)
	private String Contact_Type;
//	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "vinContact")
//	private List<VINProjection> vin;
	
	@Column(length = 100)
	private String customer_Id;

	
	
	
	

}
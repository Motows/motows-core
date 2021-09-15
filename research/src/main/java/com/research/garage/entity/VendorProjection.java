package com.research.garage.entity;
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

import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Vendor")
@Table(name = "Vendor")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorProjection {
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "demo_sql")
	@GenericGenerator(name = "demo_sql",strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator",parameters = {
			
			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM,value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER,value = "VNDR_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER,value = "%05d"),
			
			
			
	} )
	@Id
	@Column(unique=true, length = 50)
	private String VendorID; 
	@Column(length = 100)
	private String Vendor_Name;
	@Column(length = 100)
	private String Vendor_Name_Caption;
	@Column(length = 100)
	private String Vendor_NameUI;
	 @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
		@JoinColumn(name="orgId")
	private OrganisationProjection organisation;
	@Column(length = 100)
	private String Type;
	@Column(length = 100)
	private String EmailID;
	@Column(length = 100)
	private String Address;
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="country_Id")	 
	private CountryProjection country;
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="state_Id")	
	private StateProjection state;
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="zipCode_Id")	
	private ZipCodeProjection zipcode;
	@Column(length = 10)
	private String Mobile_No;
	@Column(length = 50)
	private String Mobile_No_Verified;
	@Column(length = 50)
	private String EmailIDVerified;
	@Column(length = 50)
	private String GSTIN;	
}
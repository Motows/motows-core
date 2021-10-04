package com.research.garage.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;
import com.research.vehicle.entity.ModelProjection;
import com.research.vehicle.entity.VIN_ContactProjection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Customer")
@Table(name = "Customer")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerProjection {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo_sql")
	@GenericGenerator(name = "demo_sql", strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator", parameters = {

			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "CUST_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER, value = "%05d"), })
	@Id
	@Column(updatable = false, nullable = false, length = 50)
	private String customer_Id;
	@Column(length = 50)
	private String customer_Name;
	@Column(length = 50)
	private String customer_Name_Caption;
	@Column(length = 50)
	private String customer_Name_Ui;
	
	@Column(length = 50)
	private String organisation_Id;

//	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinColumn(name = "organisation_Id", referencedColumnName = "orgId")
//	private OrganisationProjection organisation;

	@Column(length = 50)
	private String type;
	@Column(length = 50)
	private String email_Id;
	@Column(length = 50)
	private String address;
	
	@Column(length = 50)
	private String country_Id;

//	@OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinColumn(name = "country_Id", referencedColumnName = "countryId")
//	@ToString.Exclude
//	private CountryProjection country;
	
//	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinColumn(name = "country_Id",referencedColumnName = "countryId")
//	@ToString.Exclude
//	private CountryProjection country;

	@Column(length = 50)
	private String state_Id;
	
	@Column(length = 50)
	private String zip_Code_Id;
	
//	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinColumn(name = "state_Id", referencedColumnName = "state_Id")
//	private StateProjection state;
//
//	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinColumn(name = "zip_Code_Id", referencedColumnName = "zip_Code_Id")
//	private ZipCodeProjection zipCode;

//	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
//			CascadeType.REMOVE }, mappedBy = "customer")
//	private List<VIN_ContactProjection> vinContact;

	@Column(length = 10)
	private String mobile_No;
	@Column(length = 50)
	private String mobile_No_Verified;
	@Column(length = 50)
	private String email_Id_Verified;

	@Column(length = 50)
	private String gst_In;

}

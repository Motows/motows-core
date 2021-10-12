package com.research.garage.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Country")
@Table(name = "Country")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CountryProjection {

//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "demo_sql")
//	@GenericGenerator(name = "demo_sql",strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator",parameters = {
//			
//			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM,value = "1"),
//			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER,value = "CUNT_"),
//			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER,value = "%05d"),
//	} )
	@Id
	@Column(updatable = false, nullable = false, length = 50)
	private String CountryID;

	@Column(length = 50)
	private String Country_Short_Name;
	@Column(length = 50)
	private String Country_Short_Name_Caption;
	@Column(length = 50)
	private String Country_Short_NameUI;
	@Column(length = 50)
	private String Country_Long_Name;
	@Column(length = 50)
	private String Country_Long_Name_Caption;
	@Column(length = 50)
	private String Country_Long_NameUI;

//	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
//			CascadeType.REMOVE }, mappedBy = "country")
//	private List<GarageProjection> garage;
//
//	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinTable(name = "OrganisationCountry", joinColumns = @JoinColumn(name = "CountryID"), inverseJoinColumns = @JoinColumn(name = "OrgID"))
//	private List<OrganisationProjection> organisation;

//	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
//			CascadeType.REMOVE }, mappedBy = "country")
//	private List<StateProjection> states;

//	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
//			CascadeType.REMOVE }, mappedBy = "country")
//	private List<ZipCodeProjection> zipCode;

//	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
//			CascadeType.REMOVE }, mappedBy = "country")
//	private List<CustomerProjection> customer;
	
//	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
//			CascadeType.REMOVE }, mappedBy = "country")
//	private List<VendorProjection> Vendors;

//	public void addOrganisation(OrganisationProjection theOrganisation) {
//
//		if (organisation == null) {
//			organisation = new ArrayList<>();
//		}
//		organisation.add(theOrganisation);
//	}
}

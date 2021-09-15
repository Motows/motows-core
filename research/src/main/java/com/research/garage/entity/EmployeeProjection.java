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

@Entity(name ="Employee")
@Table(name ="Employee")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProjection {

	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "demo_sql")
	@GenericGenerator(name = "demo_sql",strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator",parameters = {
			
			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM,value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER,value = "EMP_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER,value = "%05d"),
	} )
	@Id
	@Column(updatable = false, nullable = false, length = 50)
	private String employee_Id;
	@Column(length = 50)
	private String employee_Name;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="organisation_Id")
	private OrganisationProjection organisation;
	
	@Column(length = 10)
	private String mobile_No;
	@Column(length = 50)
	private String email_Id;
	@Column(length = 50)
	private String Role;
	@Column(length = 50)
	private String status;
	
	
}

package com.research.sparecat.entity;

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

@Entity(name ="OrgPartMake")
@Table(name ="OrgPartMake")
@EntityListeners(AuditingEntityListener.class)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrgPartMakeProjection {

	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "demo_sql")
	@GenericGenerator(name = "demo_sql",strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator",parameters = {
			
			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM,value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER,value = "ORGPARTMK_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER,value = "%05d"),
	
	} )
	@Id
	@Column(unique=true, length = 50)
	private String part_Make_Id;
	
	@Column(length = 50)
	private String part_Make_Name ;
	
	@Column(length = 50)
	private String organisationID;
	
	@Column(length = 50)
	private String parts_Make_Caption;
	
	@Column(length = 50)
	private String parts_Make_Ui;
	
	
	
	
	
	
	
}

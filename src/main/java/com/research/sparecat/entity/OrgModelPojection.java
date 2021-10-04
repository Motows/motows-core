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

@Entity(name = "OrgModel")
@Table(name = "OrgModel")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgModelPojection {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo_sql")
	@GenericGenerator(name = "demo_sql", strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator", parameters = {

			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "ORMOD_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER, value = "%05d"),

	})
	@Id
	@Column(unique = true, length = 50)
	private String Model_ID;

	@Column(length = 250)
	private String Organisation_ID;

	@Column(length = 250)
	private String Part_ID;

	@Column(length = 250)
	private String Model_Description;

	@Column(length = 250)
	private String Model_Caption;

	@Column(length = 250)
	private String Model_UI;

}
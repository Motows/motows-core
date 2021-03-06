package com.research.jobservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Job_Template")
@Table(name = "Job_Template")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobTemplateProjection {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demo_sql")
	@GenericGenerator(name = "demo_sql", strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator", parameters = {

			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "JOBTEMP_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER, value = "%05d"),

	})
	@Id
	@Column(unique = true, length = 50)
	private String job_Template_Id;
	@Column(length = 50)
	private String job_Template_Discription;
	@Column(length = 50)
	private String job_Template_Caption;
	@Column(length = 50)
	private String job_Temp_Ui;
	@Column(length = 50)
	private String model_Id;
	@Column(length = 50)
	private String organisation_Id;
	@Column(length = 50)
	private String garage_Id;
	@Column(length = 50)
	private String category;
	@Column(length = 10)
	private int price;

}

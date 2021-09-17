package com.research.jobservice.entity;
import java.util.Date;

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

@Entity(name ="Job_Card")
@Table(name ="Job_Card")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class JobCardProjection  {
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "demo_sql")
	@GenericGenerator(name = "demo_sql",strategy = "com.research.research.outputadapters.entity.StringPrefixedSequenceGenerator",parameters = {
			
			@Parameter(name = StringPrefixedSequenceGenerator.INCREMENT_PARAM,value = "1"),
			@Parameter(name = StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER,value = "JBC_"),
			@Parameter(name = StringPrefixedSequenceGenerator.NUMBER_FORMATE_PARAMETER,value = "%05d"),
			
			
			
	} )
	@Id
	@Column(unique=true, length = 50)
    private String Job_CardID;
    @Column(length = 100)
    private String OrganisationID;
    @Column(length = 100)
    private String Job_Card_Type;
    @Column(length = 100)
    private String Job_Card_Status;
    private Date Job_Creation_Date;
    private Date Estimated_Completion_Date;
    @Column(length = 100)
    private String Vehicle_Reg_No;
    @Column(length = 100)
    private String CustomerID;
    @Column(length = 100)
    private String EmployeeID;
    
    
}

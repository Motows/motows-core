package com.research.jobservice.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor

public class JobCodeDTO {
	@Column(unique=true, length = 50)
    private String JobCardID;
    @Column(length = 100)
    private String OrganisationID;
    @Column(length = 100)
    private String JobCardType;
    @Column(length = 100)
    private String JobCardStatus;
    private Date JobCreationDate;
    private Date EstimatedCompletionDate;
    @Column(length = 100)
    private String VehicleRegNo;
    @Column(length = 100)
    private String CustomerID;
    @Column(length = 100)
    private String EmployeeID;

}

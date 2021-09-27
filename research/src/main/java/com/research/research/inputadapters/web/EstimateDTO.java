package com.research.research.inputadapters.web;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.research.garage.dto.CustomerDTO;
import com.research.jobservice.dto.JobDTO;
import com.research.jobservice.dto.JobItemsDTO;
import com.research.vehicle.dto.VINDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class EstimateDTO {
	List<JobDTO> jobs=new ArrayList<JobDTO>();
	List<JobDTO> voice=new ArrayList<JobDTO>();
	List<JobItemsDTO> parts=new ArrayList<JobItemsDTO>();
	CustomerDTO customer=new CustomerDTO();
	VINDTO vehicle=new VINDTO();
	private int jobCount;
	private int voiceCount;
	private int partsCount;
	private int Total;
}	

package com.research.garage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.EmployeeDTO;
import com.research.garage.iservice.IEmployeeRepository;



@Component
public class EmployeeService {

	private final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	
	
	public String saveEmployee(EmployeeDTO employeeDTO) {
		
		return this.employeeRepository.saveEmployee(employeeDTO);
	}

	public EmployeeDTO getEmployeeById(String employeeId) {
		
		return this.employeeRepository.getEmployeeById(employeeId);
	}

	public String deleteEmployeeById(String employeeId) {
		
		return this.employeeRepository.deleteEmployeeById(employeeId);
	}

	public String UpdateEmployee(EmployeeDTO employeeDTO) {
		
		return this.employeeRepository.UpdateEmployee(employeeDTO);
	}
	
}
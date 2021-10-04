package com.research.garage.iservice;

import org.springframework.stereotype.Component;

import com.research.garage.dto.EmployeeDTO;



@Component
public interface IEmployeeRepository {

	String saveEmployee(EmployeeDTO employeeDTO);
	EmployeeDTO getEmployeeById(String employeeId);
	
	 String deleteEmployeeById(String employeeId);

	String UpdateEmployee(EmployeeDTO employeeDTO);
}
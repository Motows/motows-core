package com.research.garage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.dto.EmployeeDTO;
import com.research.garage.service.EmployeeService;


@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
    public String addEmployee(@RequestBody EmployeeDTO employeeDTO){
    	return this.employeeService.saveEmployee(employeeDTO);
    }
	
	@GetMapping("/getEmployee/{employeeId}")
	public EmployeeDTO getEmployeeById(@PathVariable("employeeId") String employeeId) {
		
		return this.employeeService.getEmployeeById(employeeId);
	}
	@DeleteMapping("/deleteEmployeeById/{employeeId}")
	public String deleteEmployeeId(@PathVariable("employeeId") String employeeId) {
		
		return this.employeeService.deleteEmployeeById(employeeId);
	}
	@PostMapping("/updateEmployee")
	public String UpdateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return this.employeeService.UpdateEmployee(employeeDTO);
	}
	
}
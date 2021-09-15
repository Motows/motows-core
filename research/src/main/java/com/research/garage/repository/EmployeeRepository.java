package com.research.garage.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.EmployeeDAO;
import com.research.garage.dao.OrganisationDAO;
import com.research.garage.dto.EmployeeDTO;
import com.research.garage.entity.EmployeeProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.garage.iservice.IEmployeeRepository;



@Component
public class EmployeeRepository implements IEmployeeRepository {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private OrganisationDAO organisationDAO;
	
	
	@Override
	public String saveEmployee(EmployeeDTO employeeDTO) {
	
		OrganisationProjection org = organisationDAO.getOne(employeeDTO.getOrganisationId());
		
		EmployeeProjection employee = new EmployeeProjection();
		
		employee.setEmployee_Name(employeeDTO.getEmployeeName());
		employee.setEmail_Id(employeeDTO.getEmailId());
		employee.setMobile_No(employeeDTO.getMobileNo());
		employee.setRole(employeeDTO.getRole());
		employee.setStatus(employeeDTO.getStatus());
		employee.setOrganisation(org);
		
		employeeDAO.save(employee);
		
		return "Employee Saved";
	}

	@Override
	public EmployeeDTO getEmployeeById(String employeeId) {
	
		EmployeeProjection employee = employeeDAO.getOne(employeeId);
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setEmployeeId(employee.getEmployee_Id());
		employeeDTO.setEmployeeName(employee.getEmployee_Name());
		employeeDTO.setMobileNo(employee.getMobile_No());
		employeeDTO.setEmailId(employee.getEmail_Id());
		employeeDTO.setRole(employee.getRole());
		employeeDTO.setStatus(employee.getStatus());
		employeeDTO.setOrganisationId(employee.getOrganisation().getOrgID());
		
		
		return employeeDTO;
	}

	@Override
	public String deleteEmployeeById(String employeeId) {
		employeeDAO.deleteById(employeeId);
		return "Employee Deleted";
	}

	@Override
	public String UpdateEmployee(EmployeeDTO employeeDTO) {
		EmployeeProjection employee = employeeDAO.getOne(employeeDTO.getEmployeeId());
		
		
		employee.setEmployee_Name(employeeDTO.getEmployeeName());
		employee.setMobile_No(employeeDTO.getMobileNo());
		employee.setEmail_Id(employeeDTO.getEmailId());
		employee.setRole(employeeDTO.getRole());
		employee.setStatus(employeeDTO.getStatus());
		
		return "Employee Updated";
	}

}
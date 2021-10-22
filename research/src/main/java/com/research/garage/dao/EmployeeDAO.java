package com.research.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.EmployeeProjection;
import com.research.garage.entity.GarageProjection;



@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeProjection, String> {
	@Query(value = "Select * FROM employee  where employee_id=?1 ", nativeQuery = true)
	EmployeeProjection getOne(String garageId);

}
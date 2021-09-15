package com.research.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.EmployeeProjection;



@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeProjection, String> {

}
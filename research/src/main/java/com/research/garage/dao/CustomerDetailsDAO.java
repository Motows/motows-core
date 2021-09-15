package com.research.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.CustomerDetailsProjection;

@Repository
public interface CustomerDetailsDAO extends JpaRepository<CustomerDetailsProjection, Long> {

}

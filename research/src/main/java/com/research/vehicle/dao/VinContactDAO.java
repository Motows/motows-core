package com.research.vehicle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.vehicle.entity.VIN_ContactProjection;

@Repository
public interface VinContactDAO extends JpaRepository<VIN_ContactProjection, String>  {
	
	@Query(value = "Select * FROM vin_contact  where customer_id=? ", nativeQuery = true)
	List<VIN_ContactProjection> getAllByCustomerId  (String customerid);
	
	@Query(value = "Select * FROM vin_contact  where vehicleid=? ", nativeQuery = true)
	List<VIN_ContactProjection> getAllByRegNo  (String vehicleid);

	
}

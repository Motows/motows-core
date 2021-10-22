package com.research.vehicle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.research.outputadapters.repositories.Vin;
import com.research.vehicle.entity.VINProjection;

@Repository
public interface VINDAO extends JpaRepository<VINProjection, String>  {

	@Query(value = "Select * FROM vin  where vehicleid=? ", nativeQuery = true)
	List<VINProjection> getAllByVehicleId  (String vehicleid);
	
	@Query(value = "Select * FROM vin  where vinreg_no=? ", nativeQuery = true)
	List<VINProjection> getAllByVinRegNo  (String vinRegNo);
	
	@Query(value = "Select * FROM vin  where vinreg_no=? ", nativeQuery = true)
	VINProjection getVehicle  (String vinRegNo);
	
	@Query(value = "Select * FROM vin  where vinreg_no=? ", nativeQuery = true)
	VINProjection getOne  (String vinRegNo);
}

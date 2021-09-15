package com.research.garage.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.GarageProjection;



@Repository
public interface GarageDAO extends JpaRepository<GarageProjection, Long> {

	@Modifying
    @Transactional
	@Query(value = "Delete FROM garage  where garage_id=?1 ", nativeQuery = true)
	void deleteGarageById(String garageId);

	@Query(value = "Select * FROM garage  where garage_id=?1 ", nativeQuery = true)
	GarageProjection getOne(String garageId);


}

package com.research.vehicle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.vehicle.entity.ColorProjection;
import com.research.vehicle.entity.ModelProjection;
@Repository
public interface ModelDAO extends JpaRepository<ModelProjection, String> {
	@Query(value = "Select * FROM model  where model_id=?1 ", nativeQuery = true)
	ModelProjection getOne(String model_id);
}

package com.research.vehicle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.research.vehicle.entity.ColorProjection;
@Repository
public interface ColorDAO extends JpaRepository<ColorProjection, String> {
	@Query(value = "Select * FROM color  where color_id=?1 ", nativeQuery = true)
	ColorProjection getOne(String color_id);
}

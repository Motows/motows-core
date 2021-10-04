package com.research.vehicle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.vehicle.entity.BrandProjection;
import com.research.vehicle.entity.ModelProjection;
@Repository
public interface BrandDAO extends JpaRepository<BrandProjection, String> {
	@Query(value = "Select * FROM brand  where brand_id=?1 ", nativeQuery = true)
	BrandProjection getOne(String model_id);
	
	@Query(value = "Select * FROM brand", nativeQuery = true)
	List<BrandProjection> getBrandList();
}

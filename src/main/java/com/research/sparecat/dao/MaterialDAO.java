package com.research.sparecat.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.sparecat.entity.MaterialProjection;
import com.research.vehicle.entity.ModelProjection;;
@Repository
public interface MaterialDAO  extends JpaRepository<MaterialProjection, String> {
	@Query(value = "Select * FROM material  where category=?1 and partid=?2 ", nativeQuery = true)
	MaterialProjection getParts(String model_id,String part_id);
}

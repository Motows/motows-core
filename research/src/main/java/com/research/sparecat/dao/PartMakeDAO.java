package com.research.sparecat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.sparecat.entity.PartMakeProjection;
@Repository
public interface PartMakeDAO extends JpaRepository<PartMakeProjection, String> {
	@Query(value = "Select * FROM part_make  where part_make_id=?1 ", nativeQuery = true)
	PartMakeProjection getOne(String part_make_id);
}

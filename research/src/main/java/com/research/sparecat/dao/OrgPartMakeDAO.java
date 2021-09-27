package com.research.sparecat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.sparecat.entity.OrgMaterialProjection;
import com.research.sparecat.entity.OrgPartMakeProjection;
@Repository
public interface OrgPartMakeDAO extends JpaRepository<OrgPartMakeProjection, String> {
	@Query(value = "Select * FROM org_part_make  where part_make_id=?1 ", nativeQuery = true)
	OrgPartMakeProjection getOne(String part_make_id);
}

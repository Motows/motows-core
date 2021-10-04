package com.research.sparecat.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.sparecat.entity.OrgModelPojection;
import com.research.vehicle.entity.ModelProjection;

@Repository
public interface OrgModelDAO extends JpaRepository<OrgModelPojection, String>  {

	@Query(value = "Select * FROM model  where organisation_id=?1 and model_id=?2 ", nativeQuery = true)
	List<OrgModelPojection> getList(String orgID,String modelID);

}
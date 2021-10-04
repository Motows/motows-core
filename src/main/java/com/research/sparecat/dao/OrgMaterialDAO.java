package com.research.sparecat.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.sparecat.entity.OrgMaterialProjection;
import com.research.sparecat.entity.OrgModelPojection;

@Repository
public interface OrgMaterialDAO extends JpaRepository<OrgMaterialProjection, String>  {


	@Query(value = "Select * FROM org_material  where organisationid=?1 and partid=?2 ", nativeQuery = true)
	List<OrgMaterialProjection> getorgmaterialByOrgIDPartID(String orgID,String partID);
	
	@Query(value = "Select * FROM org_material  where partid=?1 ", nativeQuery = true)
	OrgMaterialProjection getOne(String orgmatId);

}

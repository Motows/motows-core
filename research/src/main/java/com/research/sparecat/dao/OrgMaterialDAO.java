package com.research.sparecat.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.sparecat.entity.OrgMaterialProjection;

@Repository
public interface OrgMaterialDAO extends JpaRepository<OrgMaterialProjection, String>  {


	

}

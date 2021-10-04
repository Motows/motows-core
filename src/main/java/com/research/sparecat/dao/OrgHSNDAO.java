package com.research.sparecat.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.sparecat.entity.OrgHSNProjection;

@Repository
public interface OrgHSNDAO extends JpaRepository<OrgHSNProjection, String>  {


}

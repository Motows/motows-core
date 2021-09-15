package com.research.sparecat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.sparecat.entity.OrgPartMakeProjection;
@Repository
public interface OrgPartMakeDAO extends JpaRepository<OrgPartMakeProjection, String> {

}

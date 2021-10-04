package com.research.sparecat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.sparecat.entity.PartMakeProjection;
@Repository
public interface PartMakeDAO extends JpaRepository<PartMakeProjection, String> {

}

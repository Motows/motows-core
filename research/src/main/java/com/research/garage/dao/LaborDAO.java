package com.research.garage.dao;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.LaborProjection;

@Repository
public interface LaborDAO extends JpaRepository<LaborProjection, Long>  {

	@Modifying
    @Transactional
	@Query(value = "Delete FROM Labor  where laborid=?1 ", nativeQuery = true)
	void deleteLaborById(String laborid);

	@Query(value = "Select * FROM Labor  where laborid=?1 ", nativeQuery = true)
	LaborProjection getOne(String laborid);
}
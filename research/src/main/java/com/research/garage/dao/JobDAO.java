package com.research.garage.dao;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.JobProjection;

@Repository
public interface JobDAO extends JpaRepository<JobProjection, Long>  {

	@Modifying
    @Transactional
	@Query(value = "Delete FROM job  where jobid=?1 ", nativeQuery = true)
	void deletejobById(String jobid);

	@Query(value = "Select * FROM job  where jobid=?1 ", nativeQuery = true)
	JobProjection getOne(String jobid);

	

	

}

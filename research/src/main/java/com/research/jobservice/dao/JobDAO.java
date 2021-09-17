package com.research.jobservice.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.jobservice.entity.JobProjection;

@Repository
public interface JobDAO extends JpaRepository<JobProjection, Long>  {

	@Modifying
    @Transactional
	@Query(value = "Delete FROM job  where jobid=?1 ", nativeQuery = true)
	void deletejobById(String jobid);

	@Query(value = "Select * FROM job  where jobid=?1 ", nativeQuery = true)
	JobProjection getOne(String jobid);
	
	@Query(value = "Select * FROM job  where jobCardid=?1 ", nativeQuery = true)
	List<JobProjection> getList(String jobCardid);
//	
//	@Query(value = "Select * FROM job  where model=?1 && organisationid=?2 and category=?3", nativeQuery = true)
//	List<JobProjection> getJobdetailsByAnySearchWithCategory(String modelId,String organisationid, String category);
//	
//	@Query(value = "Select * FROM job  where model=?1 && organisationid=?2 and  (job_description like %?3% or job_description_caption  like %?3%)"  , nativeQuery = true)
//	List<JobProjection> getJobdetailsByAnySearchWithDesc(String modelId,String organisationid, String desc);

	

	

}

package com.research.sparecat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.jobservice.entity.JobItemsProjection;
import com.research.sparecat.entity.HSNProjection;

@Repository
public interface HSNDAO extends JpaRepository<HSNProjection, String>  {


//	@Query(value = "Delete FROM job_items  where job_item_id=?1 ", nativeQuery = true)
//	void deletejobById(String jobid);

	@Query(value = "Select * FROM hsn  where hsncode=?1 ", nativeQuery = true)
	HSNProjection getOne(String hsncode);

	

}
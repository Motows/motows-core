package com.research.jobservice.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.jobservice.entity.JobCardProjection;
import com.research.jobservice.entity.JobTemplateProjection;


@Repository
public interface JobCodeDAO extends JpaRepository<JobCardProjection, String>  {


	@Query(value = "Select * FROM job_card  where Job_CardID=?1", nativeQuery = true)
	JobCardProjection getOne(String Job_CardID);
	

	

}
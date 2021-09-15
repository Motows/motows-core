package com.research.jobservice.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.jobservice.entity.JobCardProjection;


@Repository
public interface JobCodeDAO extends JpaRepository<JobCardProjection, String>  {


	

	

}
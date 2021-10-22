package com.research.jobservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.jobservice.entity.JobCardStatusProjection;
@Repository
public interface JobCardStatusDAO extends JpaRepository<JobCardStatusProjection, String> {
	@Query(value = "Select * FROM job_card_status  where job_card_status_id=?1", nativeQuery = true)
	JobCardStatusProjection getOne(String job_card_status_id);
}

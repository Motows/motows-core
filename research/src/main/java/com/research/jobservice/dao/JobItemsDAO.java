package com.research.jobservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.jobservice.entity.JobItemsProjection;

/**
 * @author Gaurav
 *
 */

@Repository
public interface JobItemsDAO extends JpaRepository<JobItemsProjection, String> {
	@Query(value = "Select * FROM job_items  where job_cardid=?1 ", nativeQuery = true)
	List<JobItemsProjection> getList(String jobCardid);
}

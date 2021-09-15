package com.research.jobservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.jobservice.entity.JobItemsProjection;

/**
 * @author Gaurav
 *
 */

@Repository
public interface JobItemsDAO extends JpaRepository<JobItemsProjection, String> {

}

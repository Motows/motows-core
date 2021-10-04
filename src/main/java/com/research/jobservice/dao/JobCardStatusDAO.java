package com.research.jobservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.jobservice.entity.JobCardStatusProjection;
@Repository
public interface JobCardStatusDAO extends JpaRepository<JobCardStatusProjection, String> {

}

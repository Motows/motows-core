package com.research.jobservice.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.jobservice.entity.JobitemTypeProjection;


@Repository
public interface JobItemTypeDAO extends JpaRepository<JobitemTypeProjection, String> {

}

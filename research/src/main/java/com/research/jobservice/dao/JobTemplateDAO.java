package com.research.jobservice.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.jobservice.entity.JobTemplateProjection;

@Repository
public interface JobTemplateDAO extends JpaRepository<JobTemplateProjection, String> {

}

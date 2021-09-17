package com.research.jobservice.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.research.jobservice.entity.JobTemplateProjection;

@Repository
public interface JobTemplateDAO extends JpaRepository<JobTemplateProjection, String> {
	@Query(value = "Select * FROM job_template  where model_id=?1 && organisation_id=?2 and category=?3", nativeQuery = true)
	List<JobTemplateProjection> getJobdetailsByAnySearchWithCategory(String modelId,String organisationid, String category);
	
	@Query(value = "Select * FROM job_template  where model_id=?1 && organisation_id=?2 and  (job_template_discription like %?3% or job_template_caption  like %?3%)"  , nativeQuery = true)
	List<JobTemplateProjection> getJobdetailsByAnySearchWithDesc(String modelId,String organisationid, String desc);

}

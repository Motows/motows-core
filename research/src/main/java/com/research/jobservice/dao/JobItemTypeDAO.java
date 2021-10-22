package com.research.jobservice.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.research.jobservice.entity.JobitemTypeProjection;


@Repository
public interface JobItemTypeDAO extends JpaRepository<JobitemTypeProjection, String> {
	@Query(value = "Select * FROM jobitem_type  where jobitemtypeid=?1 ", nativeQuery = true)
	JobitemTypeProjection getOne(String jobitemtypeid);

}

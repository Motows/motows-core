package com.research.sparecat.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.research.sparecat.entity.OrgHSNProjection;

@Repository
public interface OrgHSNDAO extends JpaRepository<OrgHSNProjection, String>  {
	@Query(value = "Select * FROM orghsn  where hsncode=?1 ", nativeQuery = true)
	OrgHSNProjection getOne(String hsncode);

}

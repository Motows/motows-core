package com.research.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.OrganisationProjection;

@Repository
public interface OrganisationDAO extends JpaRepository<OrganisationProjection, String>  {

//	@Modifying
//    @Transactional
//	@Query(value = "Delete FROM Organisation  where OrgID=?1 ", nativeQuery = true)
//	void deleteByOrganisationId(String organisationId);

	@Query(value = "Select * FROM Organisation  where OrgID=?1 ", nativeQuery = true)
	OrganisationProjection getOne(String organisationId);

	

	

}

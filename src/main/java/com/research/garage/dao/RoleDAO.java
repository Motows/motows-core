package com.research.garage.dao;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.RoleProjection;

@Repository
public interface RoleDAO extends JpaRepository<RoleProjection, Long>  {

	@Modifying
    @Transactional
	@Query(value = "Delete FROM Role  where role_id=?1 ", nativeQuery = true)
	void deleteRoleById(String roleId);

	@Query(value = "Select * FROM Role  where role_id=?1 ", nativeQuery = true)
	RoleProjection getOne(String roleId);

	

	

}

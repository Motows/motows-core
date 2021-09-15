package com.research.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.CountryProjection;
import com.research.garage.entity.StateProjection;

@Repository
public interface StateDAO extends JpaRepository<StateProjection, String> {
	@Query(value = "Select * FROM state  where state_id=?1 ", nativeQuery = true)
	StateProjection getOne(String state_id);
}

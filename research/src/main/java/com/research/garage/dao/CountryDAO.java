package com.research.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.CountryProjection;
import com.research.garage.entity.OrganisationProjection;



@Repository
public interface CountryDAO extends JpaRepository<CountryProjection, String> {
	@Query(value = "Select * FROM country  where countryid=?1 ", nativeQuery = true)
	 CountryProjection getOne(String countryid);

}

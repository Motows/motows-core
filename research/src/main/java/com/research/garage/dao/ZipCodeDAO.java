package com.research.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.CountryProjection;
import com.research.garage.entity.ZipCodeProjection;



@Repository
public interface ZipCodeDAO extends JpaRepository<ZipCodeProjection, String> {
	@Query(value = "Select * FROM zip_code  where zip_code_id=?1 ", nativeQuery = true)
	 ZipCodeProjection getOne(String zip_code_id);
}

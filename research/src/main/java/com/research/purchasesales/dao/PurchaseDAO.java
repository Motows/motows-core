package com.research.purchasesales.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.purchasesales.entity.PurchaseLineProjection;
import com.research.purchasesales.entity.PurchaseProjection;

@Repository
public interface PurchaseDAO extends JpaRepository<PurchaseProjection, String> {
	@Query(value = "Select * FROM purchase  where purcahseid=?1 ", nativeQuery = true)
	PurchaseProjection getOne(String purchaseId);
	
	@Query(value = "Select * FROM purchase  where organisationid=?1 and cast(entry_date as date) between ?2 and ?3", nativeQuery = true)
	List<PurchaseProjection> getPurchaseList(String organisation_id,String fromdate,String todate);

}
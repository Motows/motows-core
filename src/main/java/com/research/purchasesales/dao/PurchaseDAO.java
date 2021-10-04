package com.research.purchasesales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.purchasesales.entity.PurchaseProjection;

@Repository
public interface PurchaseDAO extends JpaRepository<PurchaseProjection, String> {
	@Query(value = "Select * FROM purchase  where purcahseid=?1 ", nativeQuery = true)
	PurchaseProjection getOne(String purchaseId);
}
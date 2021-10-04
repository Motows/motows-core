package com.research.purchasesales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.purchasesales.entity.PurchaseLineProjection;

@Repository
public interface PurchaseLineDAO extends JpaRepository<PurchaseLineProjection, String> {
	@Query(value = "Select * FROM purchase_line  where purcahse_line_id=?1 ", nativeQuery = true)
	PurchaseLineProjection getOne(String purchaseLineId);
}

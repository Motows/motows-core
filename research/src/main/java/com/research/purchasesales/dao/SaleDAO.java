package com.research.purchasesales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.research.purchasesales.entity.SaleProjection;

public interface SaleDAO extends JpaRepository<SaleProjection, String> {
	@Query(value = "Select * FROM sales  where sales_id=?1 ", nativeQuery = true)
	SaleProjection getOne(String sales_id);
}

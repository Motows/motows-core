package com.research.purchasesales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.purchasesales.entity.InventoryProjection;
import com.research.purchasesales.entity.SaleProjection;




@Repository
public interface InventoryDAO extends JpaRepository<InventoryProjection, String>  {


	
	@Query(value = "Select * FROM inventory  where entryno=?1 ", nativeQuery = true)
	InventoryProjection getOne(String entryno);
	

}
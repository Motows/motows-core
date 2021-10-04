package com.research.purchasesales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.purchasesales.entity.InventoryProjection;




@Repository
public interface InventoryDAO extends JpaRepository<InventoryProjection, String>  {


	

	

}
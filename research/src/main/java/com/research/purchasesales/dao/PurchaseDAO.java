package com.research.purchasesales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.purchasesales.entity.PurchaseProjection;
@Repository
public interface PurchaseDAO extends JpaRepository<PurchaseProjection, String> {

}
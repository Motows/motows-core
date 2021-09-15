package com.research.purchasesales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.purchasesales.entity.PurchaseLineProjection;
@Repository
public interface PurchaseLineDAO extends JpaRepository<PurchaseLineProjection, String> {

}

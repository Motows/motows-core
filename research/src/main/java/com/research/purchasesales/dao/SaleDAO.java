package com.research.purchasesales.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.purchasesales.entity.SaleProjection;

public interface SaleDAO extends JpaRepository<SaleProjection, String> {

}

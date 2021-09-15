package com.research.purchasesales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.purchasesales.entity.SalesLineProjection;

@Repository
public interface SalesLineDAO extends JpaRepository<SalesLineProjection, String> {

}

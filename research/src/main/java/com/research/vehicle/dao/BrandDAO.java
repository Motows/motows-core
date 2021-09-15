package com.research.vehicle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.vehicle.entity.BrandProjection;
@Repository
public interface BrandDAO extends JpaRepository<BrandProjection, String> {

}

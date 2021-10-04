package com.research.finance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.finance.entity.ReceiptProjection;



public interface ReceiptDAO extends JpaRepository<ReceiptProjection, String> {

}

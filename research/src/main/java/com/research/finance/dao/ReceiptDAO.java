package com.research.finance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.research.finance.entity.ReceiptProjection;
import com.research.jobservice.entity.JobProjection;



public interface ReceiptDAO extends JpaRepository<ReceiptProjection, String> {
	@Query(value = "Select * FROM receipt  where receipt_Id=?1 ", nativeQuery = true)
	ReceiptProjection getOne(String receipt);
	
	@Query(value = "Select * FROM receipt  where organisation_id=?1 and cast(date as date) between ?2 and ?3", nativeQuery = true)
	List<ReceiptProjection> getReceiptList(String organisation_id,String fromdate,String todate);
}

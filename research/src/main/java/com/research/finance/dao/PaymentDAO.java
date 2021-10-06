package com.research.finance.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.research.finance.entity.PaymentProjection;

@Repository
public interface PaymentDAO extends JpaRepository<PaymentProjection, String>  {

	@Query(value = "Select * FROM payment  where paymentid=?1 ", nativeQuery = true)
	PaymentProjection getOne(String receipt);
	@Query(value = "Select * FROM payment  where organisationid=?1 and cast(date as date) between ?2 and ?3", nativeQuery = true)
	List<PaymentProjection> getPaymentList(String organisation_id,String fromdate,String todate);
}

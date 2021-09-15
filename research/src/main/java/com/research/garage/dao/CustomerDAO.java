package com.research.garage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.CustomerProjection;
@Repository
public interface CustomerDAO extends JpaRepository<CustomerProjection, String> {
	
	@Query(value = "Select * FROM Customer  where mobile_no=?1 or customer_id=?1 ", nativeQuery = true)
	CustomerProjection getOneByMobileNoOrCustomerId(String mobile_no);
	
	@Query(value = "Select * FROM Customer  where mobile_no=?1 ", nativeQuery = true)
	List<CustomerProjection> getOneByMobileNo(String mobile_no) ;
	
	@Query(value = "Select * FROM Customer  where mobile_no=?1 ", nativeQuery = true)
	List<CustomerProjection> getList(String mobile_no) ;
	
	@Query(value = "Select * FROM Customer  where mobile_no=?1 and organisation_id=?2 ", nativeQuery = true)
	List<CustomerProjection> getCustomerListMobID_OrgID(String mobile_no,String organisation_id) ;
	
	@Query(value = "Select * FROM Customer  where customer_id=?1 and organisation_id=?2 ", nativeQuery = true)
	List<CustomerProjection> getCustomerListCustID_OrgID(String customer_id,String organisation_id) ;

}
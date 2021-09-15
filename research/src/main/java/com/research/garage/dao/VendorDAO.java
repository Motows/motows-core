package com.research.garage.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.garage.entity.VendorProjection;

@Repository
public interface VendorDAO extends JpaRepository<VendorProjection, String>  {

//	@Modifying
//    @Transactionala
//	@Query(value = "Delete FROM Vendor  where vendorid=?1 ", nativeQuery = true)
//	void deleteVendorByID(String roleId);
//
//	@Query(value = "Select * FROM Vendor  where vendorid=?1 ", nativeQuery = true)
//	VendorProjection getOne(String vendorid);

	

	

}
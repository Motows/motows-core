package com.research.finance.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.finance.entity.PaymentProjection;



@Repository
public interface PaymentDAO extends JpaRepository<PaymentProjection, String>  {



}

package com.research.sparecat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.sparecat.entity.HSNProjection;

@Repository
public interface HSNDAO extends JpaRepository<HSNProjection, String>  {


	

	

}
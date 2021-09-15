package com.research.sparecat.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.research.sparecat.entity.MaterialProjection;;
@Repository
public interface MaterialDAO  extends JpaRepository<MaterialProjection, String> {

}

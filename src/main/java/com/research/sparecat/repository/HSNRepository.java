package com.research.sparecat.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dao.HSNDAO;
import com.research.sparecat.dto.HSNDTO;
import com.research.sparecat.entity.HSNProjection;
import com.research.sparecat.iservice.IHSNRepository;


@Component
public class HSNRepository implements IHSNRepository {
	@Autowired
	private HSNDAO hsndao;

	@Override
	public String addhsn(HSNDTO hsndto) {
		HSNProjection hsnpro = new HSNProjection();
		hsnpro.setType(hsndto.getType());
		hsnpro.setDescription(hsndto.getDescription());
		hsndao.save(hsnpro);
		return "Added successfulyy";
	}

	@Override
	public HSNDTO gethsnbyCode(String hsncode) {
		HSNProjection hsnpro = hsndao.getOne(hsncode);
		HSNDTO hsndto = new HSNDTO();
		hsndto.setDescription(hsnpro.getDescription());
		hsndto.setType(hsnpro.getType());
		hsndto.setHSNCode(hsnpro.getHSNCode());
		return hsndto;
	}

	@Override
	public String deletehsnbyCode(String hsncode) {
		hsndao.deleteById(hsncode);
		return "Deleted";
	}

	@Override
	public String updatehsn(HSNDTO hsndto) {
		HSNProjection hsnpro = hsndao.getOne(hsndto.getHSNCode());
		hsnpro.setDescription(hsndto.getDescription());
		hsnpro.setType(hsndto.getType());
		hsnpro.setHSNCode(hsndto.getHSNCode());
		hsndao.save(hsnpro);
		return "Updated Successfully";
	}
	
}

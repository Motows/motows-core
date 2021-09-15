package com.research.sparecat.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dao.OrgHSNDAO;
import com.research.sparecat.dto.OrgHSNDTO;
import com.research.sparecat.entity.OrgHSNProjection;
import com.research.sparecat.iservice.IOrgHSNRepository;


@Component
public class OrgHSNRepository implements IOrgHSNRepository {
	@Autowired
	private OrgHSNDAO  OrgHSNDAO;

	@Override
	public String addorghsn(OrgHSNDTO orghsndto) {
		OrgHSNProjection orghsn = new OrgHSNProjection();
		orghsn.setDescription(orghsndto.getDescription());
		orghsn.setOrganisationID(orghsndto.getOrganisationID());
		orghsn.setType(orghsndto.getType());
		OrgHSNDAO.save(orghsn);
		return "added";
	}

	@Override
	public OrgHSNDTO gethsnbycode(String hsncode) {
		OrgHSNProjection orghsn = OrgHSNDAO.getOne(hsncode);
		OrgHSNDTO hsndto = new OrgHSNDTO();
		hsndto.setDescription(orghsn.getDescription());
		hsndto.setOrganisationID(orghsn.getOrganisationID());
		hsndto.setType(orghsn.getType());
		hsndto.setHSNCode(orghsn.getHSNCode());
		return hsndto;
	}

	@Override
	public String deleteorghsn(String hsncode) {
		OrgHSNDAO.deleteById(hsncode);
		return "deleted";
	}

	@Override
	public String updatehsn(OrgHSNDTO orghsndto) {
		OrgHSNProjection orghsn = OrgHSNDAO.getOne(orghsndto.getHSNCode());
		orghsn.setDescription(orghsndto.getDescription());
		orghsn.setOrganisationID(orghsndto.getOrganisationID());
		orghsn.setType(orghsndto.getType());
		orghsn.setHSNCode(orghsndto.getHSNCode());
		OrgHSNDAO.save(orghsn);
		return "Updated successfully";
	}
}

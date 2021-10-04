package com.research.sparecat.iservice;

import com.research.sparecat.dto.OrgHSNDTO;

public interface IOrgHSNRepository {

	String addorghsn(OrgHSNDTO orghsndto);

	OrgHSNDTO gethsnbycode(String hsncode);

	String deleteorghsn(String hsncode);

	String updatehsn(OrgHSNDTO orghsndto);

	

}

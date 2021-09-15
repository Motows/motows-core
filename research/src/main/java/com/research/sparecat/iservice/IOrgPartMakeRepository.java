package com.research.sparecat.iservice;

import com.research.sparecat.dto.OrgPartMakeDTO;

public interface IOrgPartMakeRepository {

	String addOrgPartMake(OrgPartMakeDTO orgPartMakeDTO);
	OrgPartMakeDTO getOrgPartMake(String orgPartMakeId);
	String deleteOrgPartMake(String orgPartMakeId);
	String updateOrgPartMake(OrgPartMakeDTO orgPartMakeDTO);
	
}

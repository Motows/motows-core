package com.research.sparecat.iservice;

import com.research.sparecat.dto.OrgModelDTO;

public interface IOrgModelRepository {

	String addorgmodel(OrgModelDTO orgmodelDTO);

	OrgModelDTO getorgmodelById(String modelId);

	String deleteorgmodelById(String modelId);

	String updateorgModelById(OrgModelDTO orgmodelDTO);

}

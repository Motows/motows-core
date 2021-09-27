package com.research.sparecat.iservice;

import java.util.List;

import com.research.sparecat.dto.OrgMaterialDTO;


public interface IOrgMaterialRepository {

	String addorgmaterial(OrgMaterialDTO orgMaterialDTO);

	String deleteorgmatialById(String orgmatId);

	String updateorgMaterial(OrgMaterialDTO orgMaterialDTO);

	OrgMaterialDTO getorgmaterialById(String orgmatId);

	List<OrgMaterialDTO> getorgmaterialByOrgIDPartID(String orgID,String partID);

}

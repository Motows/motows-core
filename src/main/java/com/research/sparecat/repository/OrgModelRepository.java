package com.research.sparecat.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dao.OrgModelDAO;
import com.research.sparecat.dto.OrgModelDTO;
import com.research.sparecat.entity.OrgModelPojection;
import com.research.sparecat.iservice.IOrgModelRepository;


@Component
public class OrgModelRepository implements IOrgModelRepository {
	@Autowired
	private OrgModelDAO  OrgModelDAO;
	@Override
	public String addorgmodel(OrgModelDTO orgmodelDTO) {
		OrgModelPojection orgmod = new OrgModelPojection();
		orgmod.setModel_Caption(orgmodelDTO.getModelCaption());
		orgmod.setModel_Description(orgmodelDTO.getModelDescription());
		orgmod.setModel_UI(orgmodelDTO.getModelUI());
		orgmod.setOrganisation_ID(orgmodelDTO.getOrganisationID());
		orgmod.setPart_ID(orgmodelDTO.getPartID());
		OrgModelDAO.save(orgmod);
		return "OrgModel is added successfully";
	}

	@Override
	public OrgModelDTO getorgmodelById(String modelId) {
		OrgModelPojection orgmod = OrgModelDAO.getOne(modelId);
		OrgModelDTO orgmodeldto = new OrgModelDTO();
		orgmodeldto.setModelCaption(orgmod.getModel_Caption());
		orgmodeldto.setModelDescription(orgmod.getModel_Description());
		orgmodeldto.setModelUI(orgmod.getModel_UI());
		orgmodeldto.setOrganisationID(orgmod.getOrganisation_ID());
		orgmodeldto.setPartID(orgmod.getPart_ID());
		orgmodeldto.setModelID(orgmod.getModel_ID());
		return orgmodeldto;
	}

	@Override
	public String deleteorgmodelById(String modelId) {
		OrgModelDAO.deleteById(modelId);
		return "Deleted";
	}

	@Override
	public String updateorgModelById(OrgModelDTO orgmodelDTO) {
		OrgModelPojection orgmod = OrgModelDAO.getOne(orgmodelDTO.getModelID());
		orgmod.setModel_Caption(orgmodelDTO.getModelCaption());
		orgmod.setModel_Description(orgmodelDTO.getModelDescription());
		orgmod.setModel_UI(orgmodelDTO.getModelUI());
		orgmod.setOrganisation_ID(orgmodelDTO.getOrganisationID());
		orgmod.setPart_ID(orgmodelDTO.getPartID());
		orgmod.setModel_ID(orgmodelDTO.getModelID());
		OrgModelDAO.save(orgmod);
		return "Updated successfully";
	}
	
}

package com.research.sparecat.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.OrganisationDAO;
import com.research.garage.entity.OrganisationProjection;
import com.research.sparecat.dao.OrgModelDAO;
import com.research.sparecat.dto.OrgModelDTO;
import com.research.sparecat.entity.OrgModelPojection;
import com.research.sparecat.iservice.IOrgModelRepository;


@Component
public class OrgModelRepository implements IOrgModelRepository {
	@Autowired
	private OrgModelDAO  OrgModelDAO;
	@Autowired
	private OrganisationDAO  organisationDAO;
	@Override
	public String addorgmodel(OrgModelDTO orgmodelDTO) {
		OrganisationProjection org = organisationDAO.getOne(orgmodelDTO.getOrganisationID());
		
		if(org==null)
		{
			return "Organisation ID "+ orgmodelDTO.getOrganisationID()+" not in the Master";
		}
		OrgModelPojection orgmod = new OrgModelPojection();
		orgmod.setModel_Caption(orgmodelDTO.getModelCaption());
		orgmod.setModel_Description(orgmodelDTO.getModelDescription());
		orgmod.setModelUI(orgmodelDTO.getModelUI());
		orgmod.setOrganisationID(orgmodelDTO.getOrganisationID());
		orgmod.setPartID(orgmodelDTO.getPartID());
		OrgModelDAO.save(orgmod);
		return "OrgModel is added successfully";
	}

	@Override
	public OrgModelDTO getorgmodelById(String modelId) {
		OrgModelPojection orgmod = OrgModelDAO.getOne(modelId);
		OrgModelDTO orgmodeldto = new OrgModelDTO();
		orgmodeldto.setModelCaption(orgmod.getModel_Caption());
		orgmodeldto.setModelDescription(orgmod.getModel_Description());
		orgmodeldto.setModelUI(orgmod.getModelUI());
		orgmodeldto.setOrganisationID(orgmod.getOrganisationID());
		orgmodeldto.setPartID(orgmod.getPartID());
		orgmodeldto.setModelID(orgmod.getModelID());
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
		OrganisationProjection org = organisationDAO.getOne(orgmodelDTO.getOrganisationID());
		
		if(org==null)
		{
			return "Organisation ID "+ orgmodelDTO.getOrganisationID()+" not in the Master";
		}
		orgmod.setModel_Caption(orgmodelDTO.getModelCaption());
		orgmod.setModel_Description(orgmodelDTO.getModelDescription());
		orgmod.setModelUI(orgmodelDTO.getModelUI());
		orgmod.setOrganisationID(orgmodelDTO.getOrganisationID());
		orgmod.setPartID(orgmodelDTO.getPartID());
		orgmod.setModelID(orgmodelDTO.getModelID());
		OrgModelDAO.save(orgmod);
		return "Updated successfully";
	}
	
}

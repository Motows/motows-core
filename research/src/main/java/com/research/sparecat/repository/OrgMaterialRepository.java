package com.research.sparecat.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dao.OrgMaterialDAO;
import com.research.sparecat.dto.OrgMaterialDTO;
import com.research.sparecat.entity.OrgMaterialProjection;
import com.research.sparecat.iservice.IOrgMaterialRepository;


@Component
public class OrgMaterialRepository implements IOrgMaterialRepository {
	@Autowired
	private OrgMaterialDAO  orgmaterialDAO;

	@Override
	public String addorgmaterial(OrgMaterialDTO orgMaterialDTO) {
		OrgMaterialProjection ormatpro = new OrgMaterialProjection();
		ormatpro.setCategory(orgMaterialDTO.getCategory());
		ormatpro.setHSN(orgMaterialDTO.getHSN());
		ormatpro.setOrganisationID(orgMaterialDTO.getOrganisationID());
		ormatpro.setPart_Description(orgMaterialDTO.getPartDescription());
		ormatpro.setPart_Make(orgMaterialDTO.getPartMake());
		ormatpro.setParts_Caption(orgMaterialDTO.getPartsCaption());
		ormatpro.setPartsUI(orgMaterialDTO.getPartsUI());
		ormatpro.setSales_Price(orgMaterialDTO.getSalesPrice());
		orgmaterialDAO.save(ormatpro);
		return "Added succcessfully";
	}

	@Override
	public String deleteorgmatialById(String orgmatId) {
		orgmaterialDAO.deleteById(orgmatId);
		return "Deleted";
	}

	@Override
	public String updateorgMaterial(OrgMaterialDTO orgMaterialDTO) {
		OrgMaterialProjection ormatpro = orgmaterialDAO.getOne(orgMaterialDTO.getPartID());
		ormatpro.setCategory(orgMaterialDTO.getCategory());
		ormatpro.setHSN(orgMaterialDTO.getHSN());
		ormatpro.setOrganisationID(orgMaterialDTO.getOrganisationID());
		ormatpro.setPart_Description(orgMaterialDTO.getPartDescription());
		ormatpro.setPart_Make(orgMaterialDTO.getPartMake());
		ormatpro.setParts_Caption(orgMaterialDTO.getPartsCaption());
		ormatpro.setPartsUI(orgMaterialDTO.getPartsUI());
		ormatpro.setSales_Price(orgMaterialDTO.getSalesPrice());
		ormatpro.setPartID(orgMaterialDTO.getPartID());
		orgmaterialDAO.save(ormatpro);
		return "Updated successfully";
	}

	@Override
	public OrgMaterialDTO getorgmaterialById(String orgmatId) {
		OrgMaterialProjection ormatpro = orgmaterialDAO.getOne(orgmatId);
		OrgMaterialDTO orgMaterialDTO = new OrgMaterialDTO();
		orgMaterialDTO.setCategory(ormatpro.getCategory());
		orgMaterialDTO.setHSN(ormatpro.getHSN());
		orgMaterialDTO.setOrganisationID(ormatpro.getOrganisationID());
		orgMaterialDTO.setPartDescription(ormatpro.getPart_Description());
		orgMaterialDTO.setPartMake(ormatpro.getPart_Make());
		orgMaterialDTO.setPartsCaption(ormatpro.getParts_Caption());
		orgMaterialDTO.setPartsUI(ormatpro.getPartsUI());
		orgMaterialDTO.setSalesPrice(ormatpro.getSales_Price());
		orgMaterialDTO.setPartID(ormatpro.getPartID());
		return orgMaterialDTO;
	}
}

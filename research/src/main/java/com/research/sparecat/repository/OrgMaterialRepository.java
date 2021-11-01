package com.research.sparecat.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.OrganisationDAO;
import com.research.garage.entity.OrganisationProjection;
import com.research.sparecat.dao.OrgMaterialDAO;
import com.research.sparecat.dao.OrgPartMakeDAO;
import com.research.sparecat.dto.OrgMaterialDTO;
import com.research.sparecat.entity.OrgMaterialProjection;
import com.research.sparecat.entity.OrgPartMakeProjection;
import com.research.sparecat.iservice.IOrgMaterialRepository;


@Component
public class OrgMaterialRepository implements IOrgMaterialRepository {
	@Autowired
	private OrgMaterialDAO  orgmaterialDAO;
	@Autowired
	private OrganisationDAO organisationDAO;
	
	@Autowired
	private OrgPartMakeDAO orgPartMakeDAO;
	
	@Override
	public String addorgmaterial(OrgMaterialDTO orgMaterialDTO) {
		OrgMaterialProjection ormatpro = new OrgMaterialProjection();
		String orgId=orgMaterialDTO.getOrganisationID();
		OrganisationProjection org = organisationDAO.getOne(orgId);
		if(org==null)
		{
			return "Org ID "+ orgId +" not in the Master";
		}
		
		OrgPartMakeProjection orgPartMake = orgPartMakeDAO.getOne(orgMaterialDTO.getPartMake());
		if(orgPartMake==null)
		{
			return "Org Part Make ID "+ orgMaterialDTO.getPartMake() +" not in the Master";
		}
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
		if(orgmaterialDAO.getOne(orgmatId)!=null)
		{
			orgmaterialDAO.deleteById(orgmatId);
			return "Org Material Deleted";

		}
		else
		{
			return "Org Material id Not found";
		}
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
		if(ormatpro==null)
		{
			orgMaterialDTO.setPartID("Invalid ID:"+orgmatId);
			return orgMaterialDTO;
		}
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
	
	@Override
	public List<OrgMaterialDTO> getorgmaterialByOrgIDPartID(String orgId,String partID) {
		List<OrgMaterialProjection> ormatproList = orgmaterialDAO.getorgmaterialByOrgIDPartID(orgId,partID);
		List<OrgMaterialDTO> orgMaterialDTOList=new ArrayList<OrgMaterialDTO>();
		for(OrgMaterialProjection ormatpro: ormatproList)
		{
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
		orgMaterialDTOList.add(orgMaterialDTO);
		}
		return orgMaterialDTOList;
	}
}

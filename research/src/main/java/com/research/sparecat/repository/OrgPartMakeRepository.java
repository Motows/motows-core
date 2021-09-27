package com.research.sparecat.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.OrganisationDAO;
import com.research.garage.entity.OrganisationProjection;
import com.research.garage.entity.ZipCodeProjection;
import com.research.sparecat.dao.OrgPartMakeDAO;
import com.research.sparecat.dto.OrgPartMakeDTO;
import com.research.sparecat.entity.OrgPartMakeProjection;
import com.research.sparecat.iservice.IOrgPartMakeRepository;

@Component
public class OrgPartMakeRepository implements IOrgPartMakeRepository {

	@Autowired
	private OrgPartMakeDAO orgPartMakeDAO;
	
	@Autowired
	private OrganisationDAO organisationDAO;

	@Override
	public String addOrgPartMake(OrgPartMakeDTO orgPartMakeDTO) {
		String orgId=orgPartMakeDTO.getOrganisationID();
		OrgPartMakeProjection orgPartMake = new OrgPartMakeProjection();
		OrganisationProjection org = organisationDAO.getOne(orgPartMakeDTO.getOrganisationID());
		if(org==null)
		{
			return "Org ID "+ orgId +" not in the Master";
		}
		orgPartMake.setPart_Make_Name(orgPartMakeDTO.getPartMakeName());
		orgPartMake.setParts_Make_Caption(orgPartMakeDTO.getPartsMakeCaption());
		orgPartMake.setParts_Make_Ui(orgPartMakeDTO.getPartsMakeUi());
		orgPartMake.setOrganisationID(orgPartMakeDTO.getOrganisationID());

		orgPartMakeDAO.save(orgPartMake);

		return "Org Part Make Saved";
	}

	@Override
	public OrgPartMakeDTO getOrgPartMake(String orgPartMakeId) {
		OrgPartMakeProjection orgPartMake = orgPartMakeDAO.getOne(orgPartMakeId);
		OrgPartMakeDTO orgPartMakeDTO = new OrgPartMakeDTO();
		
		orgPartMakeDTO.setPartMakeId(orgPartMake.getPart_Make_Id());
		orgPartMakeDTO.setPartMakeName(orgPartMake.getPart_Make_Name());
		orgPartMakeDTO.setPartsMakeCaption(orgPartMake.getParts_Make_Caption());
		orgPartMakeDTO.setPartsMakeUi(orgPartMake.getParts_Make_Ui());
		orgPartMakeDTO.setOrganisationID(orgPartMake.getOrganisationID());
		return orgPartMakeDTO;
	}

	@Override
	public String deleteOrgPartMake(String orgPartMakeId) {
		orgPartMakeDAO.deleteById(orgPartMakeId);

		return "Org Part Make Deleted";
	}

	@Override
	public String updateOrgPartMake(OrgPartMakeDTO orgPartMakeDTO) {
		OrgPartMakeProjection orgPartMake = orgPartMakeDAO.getOne(orgPartMakeDTO.getPartMakeId());
		
		orgPartMake.setPart_Make_Name(orgPartMakeDTO.getPartMakeName());
		orgPartMake.setParts_Make_Caption(orgPartMakeDTO.getPartsMakeCaption());
		orgPartMake.setParts_Make_Ui(orgPartMakeDTO.getPartsMakeUi());
		orgPartMake.setOrganisationID(orgPartMakeDTO.getOrganisationID());

		return "Prg Part Make Updated";
	}

}

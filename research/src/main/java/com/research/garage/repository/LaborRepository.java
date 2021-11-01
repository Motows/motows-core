package com.research.garage.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.LaborDAO;
import com.research.garage.dao.OrganisationDAO;
import com.research.garage.dto.LaborDTO;
import com.research.garage.entity.LaborProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.garage.iservice.ILaborRepository;


@Component
public class LaborRepository implements ILaborRepository {


	@Autowired
	private LaborDAO laborDAO;
	
	@Autowired
	private OrganisationDAO OrganisationDAO;

	@Override
	public String savelaborDetails(LaborDTO labordto) {
		
		OrganisationProjection org = OrganisationDAO.getOne(labordto.getOrganisationID());
		if(org==null)
		{
			return "Organisation ID "+ labordto.getOrganisationID() +" not in the Master";
		}
		LaborProjection labor = new LaborProjection();
		labor.setLabor_Description(labordto.getLaborDescription());
		labor.setLabor_Description_Caption(labordto.getLaborDescriptionCaption());
		labor.setLabor_DescriptionUI(labordto.getLaborDescriptionUI());
		labor.setHSN(labordto.getHSN());
		labor.setOrganisationID(labordto.getOrganisationID());
		laborDAO.save(labor);
		return "Details Saved";
	}
	


	@Override
	public LaborDTO getlabordetailsById(String laborId) {
		LaborProjection labor = laborDAO.getOne(laborId);

		LaborDTO response = new LaborDTO();

		response.setLaborDescription(labor.getLabor_Description());
		response.setLaborDescriptionCaption(labor.getLabor_Description_Caption());
		response.setLaborDescriptionUI(labor.getLabor_DescriptionUI());
		response.setHSN(labor.getHSN());
		response.setLaborID(labor.getLaborID());
		response.setOrganisationID(labor.getOrganisationID());

		return response;
	}
	

	@Override
	public String deleteLaborById(String laborId) {
		if(laborDAO.getOne(laborId)!=null)
		{
	        laborDAO.deleteLaborById(laborId);
			return "Labor deleted";
		}
		else
		{
			return "Labor id Not found";
		}
		
	}

	
	
	@Override
	public String UpdateLaborDetails(LaborDTO labordto) {
		LaborProjection labor =	laborDAO.getOne(labordto.getLaborID());
		OrganisationProjection org = OrganisationDAO.getOne(labordto.getOrganisationID());
		if(org==null)
		{
			return "Organisation ID "+ labordto.getOrganisationID() +" not in the Master";
		}
		labor.setLabor_Description(labordto.getLaborDescription());
		labor.setLabor_Description_Caption(labordto.getLaborDescriptionCaption());
		labor.setLabor_DescriptionUI(labordto.getLaborDescriptionUI());
		labor.setHSN(labordto.getHSN());
		labor.setLaborID(labordto.getLaborID());
		labor.setOrganisationID(labordto.getOrganisationID());
		laborDAO.save(labor);
		return "updated";
	}

}

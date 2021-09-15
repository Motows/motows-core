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
		
		OrganisationProjection country = OrganisationDAO.getOne(labordto.getOrganisationID());
		
		LaborProjection labor = new LaborProjection();
		labor.setLabor_Description(labordto.getLaborDescription());
		labor.setLabor_Description_Caption(labordto.getLaborDescriptionCaption());
		labor.setLabor_DescriptionUI(labordto.getLaborDescriptionUI());
		labor.setHSN(labordto.getHSN());
		labor.setOrganisation(country);
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

		return response;
	}
	

	@Override
	public String deleteLaborById(String laborId) {
		laborDAO.deleteLaborById(laborId);

		return "deleted";
	}

	
	
	@Override
	public String UpdateLaborDetails(LaborDTO labordto) {
		LaborProjection labor =	laborDAO.getOne(labordto.getLaborID());
		labor.setLabor_Description(labordto.getLaborDescription());
		labor.setLabor_Description_Caption(labordto.getLaborDescriptionCaption());
		labor.setLabor_DescriptionUI(labordto.getLaborDescriptionUI());
		labor.setHSN(labordto.getHSN());
		labor.setLaborID(labordto.getLaborID());
		laborDAO.save(labor);
		return "updated";
	}

}

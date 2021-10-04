package com.research.sparecat.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dao.PartMakeDAO;
import com.research.sparecat.dto.PartMakeDTO;
import com.research.sparecat.entity.PartMakeProjection;
import com.research.sparecat.iservice.IPartMakeRepository;

@Component
public class PartMakeRepository implements IPartMakeRepository {

	@Autowired
	private PartMakeDAO partMakeDAO;

	@Override
	public String addPartMake(PartMakeDTO partMakeDTO) {

		PartMakeProjection partMake = new PartMakeProjection();

		partMake.setPart_Make_Name(partMakeDTO.getPartMakeName());
		partMake.setParts_Make_Caption(partMakeDTO.getPartsMakeCaption());
		partMake.setParts_Make_Ui(partMakeDTO.getPartsMakeUi());

		partMakeDAO.save(partMake);
		return "Part Make Saved";
	}

	@Override
	public PartMakeDTO getPartMakeById(String partMakeId) {
		PartMakeProjection partMake = partMakeDAO.getOne(partMakeId);
		PartMakeDTO partMakeDTO = new PartMakeDTO();

		partMakeDTO.setPartMakeId(partMake.getPart_Make_Id());
		partMakeDTO.setPartMakeName(partMake.getPart_Make_Name());
		partMakeDTO.setPartsMakeCaption(partMake.getParts_Make_Caption());
		partMakeDTO.setPartsMakeUi(partMake.getParts_Make_Ui());
		return partMakeDTO;
	}

	@Override
	public String deletePartMake(String partMakeId) {
		partMakeDAO.deleteById(partMakeId);
		return "Part Make Deleted";
	}

	@Override
	public String updatePartMake(PartMakeDTO partMakeDTO) {
		PartMakeProjection partMake = partMakeDAO.getOne(partMakeDTO.getPartMakeId());

		partMake.setPart_Make_Name(partMakeDTO.getPartMakeName());
		partMake.setParts_Make_Caption(partMakeDTO.getPartsMakeCaption());
		partMake.setParts_Make_Ui(partMakeDTO.getPartsMakeUi());

		partMakeDAO.save(partMake);
		return "PartMake Updated.";
	}

}

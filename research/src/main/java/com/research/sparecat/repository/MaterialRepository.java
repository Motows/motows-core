package com.research.sparecat.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.sparecat.dao.MaterialDAO;
import com.research.sparecat.dto.MaterialDTO;
import com.research.sparecat.entity.MaterialProjection;
import com.research.sparecat.iservice.IMaterialRepository;

@Component
public class MaterialRepository  implements IMaterialRepository {
	@Autowired
	private MaterialDAO materialDAO;
	@Override
	public MaterialDTO getMaterialById(String partId) {
		MaterialProjection matrelpro = materialDAO.getOne(partId);

		MaterialDTO materialDTO = new MaterialDTO();
		
		materialDTO.setCategory(matrelpro.getCategory());
		materialDTO.setHSN(matrelpro.getHSN());
		materialDTO.setPartDescription(matrelpro.getPart_Description());
		materialDTO.setPartMake(matrelpro.getPart_Make());
		materialDTO.setPartsCaption(matrelpro.getParts_Caption());
		materialDTO.setPartsUI(matrelpro.getPartsUI());
		materialDTO.setSalesPrice(matrelpro.getSales_Price());
		materialDTO.setPartID(matrelpro.getPartID());
		return materialDTO;
		
		
	}

	@Override
	public String addMaterial(MaterialDTO materialDTO) {
		MaterialProjection matrelpro = new MaterialProjection();
		matrelpro.setCategory(materialDTO.getCategory());
		matrelpro.setHSN(materialDTO.getHSN());
		matrelpro.setPart_Description(materialDTO.getPartDescription());
		matrelpro.setPart_Make(materialDTO.getPartMake());
		matrelpro.setParts_Caption(materialDTO.getPartsCaption());
		matrelpro.setPartsUI(materialDTO.getPartsUI());
		matrelpro.setSales_Price(materialDTO.getSalesPrice());
		materialDAO.save(matrelpro);
		return "Material Added"; 
	}

	@Override
	public String updateMaterialById(MaterialDTO materialDTO) {
		MaterialProjection matrelpro = materialDAO.getOne(materialDTO.getPartID());
		matrelpro.setCategory(materialDTO.getCategory());
		matrelpro.setHSN(materialDTO.getHSN());
		matrelpro.setPart_Description(materialDTO.getPartDescription());
		matrelpro.setPart_Make(materialDTO.getPartMake());
		matrelpro.setParts_Caption(materialDTO.getPartsCaption());
		matrelpro.setPartsUI(materialDTO.getPartsUI());
		matrelpro.setSales_Price(materialDTO.getSalesPrice());
		matrelpro.setPartID(materialDTO.getPartID());
		materialDAO.save(matrelpro);
		return "Updated";
	}

	@Override
	public String deleteMaterialById(String partId) {
		materialDAO.deleteById(partId);
		return "Deleted";
	}

}

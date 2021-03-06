package com.research.sparecat.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.jobservice.dto.JobTemplateDTO;
import com.research.jobservice.entity.JobTemplateProjection;
import com.research.sparecat.dao.MaterialDAO;
import com.research.sparecat.dao.OrgModelDAO;
import com.research.sparecat.dao.PartMakeDAO;
import com.research.sparecat.dto.MaterialDTO;
import com.research.sparecat.entity.MaterialProjection;
import com.research.sparecat.entity.OrgModelPojection;
import com.research.sparecat.entity.OrgPartMakeProjection;
import com.research.sparecat.entity.PartMakeProjection;
import com.research.sparecat.iservice.IMaterialRepository;
import com.research.vehicle.dao.ModelDAO;
import com.research.vehicle.entity.ModelProjection;

@Component
public class MaterialRepository  implements IMaterialRepository {
	@Autowired
	private MaterialDAO materialDAO;
	@Autowired
	private OrgModelDAO orgModelDAO;
	@Autowired
	private PartMakeDAO partMakeDAO;
	@Override
	public MaterialDTO getMaterialById(String partId) {
		MaterialProjection matrelpro = materialDAO.getOne(partId);

		MaterialDTO materialDTO = new MaterialDTO();
		if(matrelpro==null)
		{
			materialDTO.setPartID("Invalid ID:"+partId);
			return materialDTO;
		}
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
		
		PartMakeProjection partMake = partMakeDAO.getOne(materialDTO.getPartMake());
		if(partMake==null)
		{
			return "Part Make ID "+ materialDTO.getPartMake() +" not in the Master";
		}
		String category=materialDTO.getCategory();
		if(category==null || category=="")
		{
			return "Category Required"; 
		}
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
		PartMakeProjection partMake = partMakeDAO.getOne(matrelpro.getPart_Make());
		if(partMake==null)
		{
			return "Part Make ID "+ matrelpro.getPart_Make() +" not in the Master";
		}
		String category=matrelpro.getCategory();
		if(category==null || category=="")
		{
			return "Category Required"; 
		}
		
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
		if(materialDAO.getOne(partId)!=null)
		{
			materialDAO.deleteById(partId);
			return "Material Deleted";
		}
		else
		{
			return "Material id Not found";
		}

	}
	
	@Override
	public List<MaterialDTO> getPartsdetailsWithCategory(String orgId,String modelID,String category) {
		List<OrgModelPojection> modelList = orgModelDAO.getList(orgId,modelID);
		List<MaterialProjection> partList = new ArrayList<MaterialProjection>();
		 for(OrgModelPojection parts:modelList)
	        {
			partList.add(materialDAO.getParts(category,parts.getPartID()));
	        }
		
		List<MaterialDTO> MaterialDTOList = new ArrayList<MaterialDTO>();
		
        for(MaterialProjection parts:partList)
        {
        	MaterialDTO mDto = new MaterialDTO();
        	mDto.setCategory(parts.getCategory());
        	mDto.setHSN(parts.getHSN());
        	mDto.setPartDescription(parts.getPart_Description());
        	mDto.setPartID(parts.getPartID());
        	mDto.setPartMake(parts.getPart_Make());
        	mDto.setPartsCaption(parts.getPart_Description());
        	mDto.setPartsUI(parts.getPartsUI());
        	mDto.setSalesPrice(parts.getSales_Price());
      //  	mDto.setOrganizationID(orgId);
        	MaterialDTOList.add(mDto);
       
        }
		return MaterialDTOList;
	}

}

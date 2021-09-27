package com.research.vehicle.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.vehicle.dto.BrandDTO;
import com.research.vehicle.dto.ModelDTO;
import com.research.vehicle.dao.ModelDAO;
import com.research.vehicle.entity.ModelProjection;
import com.research.vehicle.iservice.IModelRepository;

@Component
public class ModelRepository implements IModelRepository {

	@Autowired
	private ModelDAO modelDAO;

	@Override
	public String addModel(ModelDTO modelDTO) {
		ModelProjection model = new ModelProjection();

		model.setBody_Type(modelDTO.getBodyType());
		model.setModel_Caption(modelDTO.getModelCaption());
		model.setModel_Description(modelDTO.getModelDescription());
		model.setModel_Ui(modelDTO.getModelUi());
		model.setPart_Id(modelDTO.getPartId());
		modelDAO.save(model);

		return "Model Saved";
	}

	@Override
	public ModelDTO getModelById(String modelId) {

		ModelProjection model = modelDAO.getOne(modelId);

		ModelDTO modelDTO = new ModelDTO();

		modelDTO.setBodyType(model.getBody_Type());
		modelDTO.setModelCaption(model.getModel_Caption());
		modelDTO.setModelDescription(model.getModel_Description());
		modelDTO.setModelId(model.getModel_Id());
		modelDTO.setModelUi(model.getModel_Ui());
		modelDTO.setPartId(model.getPart_Id());

		return modelDTO;
	}

	@Override
	public String deleteModelById(String modelId) {
	modelDAO.deleteById(modelId);;
		return "Model Deleted";
	}

	@Override
	public String updateModel(ModelDTO modelDTO) {
		ModelProjection model = modelDAO.getOne(modelDTO.getModelId());

		model.setBody_Type(modelDTO.getBodyType());
		model.setModel_Caption(modelDTO.getModelCaption());
		model.setModel_Description(modelDTO.getModelDescription());
		model.setModel_Ui(modelDTO.getModelUi());
		model.setPart_Id(modelDTO.getPartId());
		modelDAO.save(model);

		return "Model Updated";
		
	}

	@Override
	public List<ModelDTO> getAllModel() {
		// TODO Auto-generated method stub
		List<ModelProjection> modelList = modelDAO.getModelList();
		List<ModelDTO> modelDTOList = new ArrayList<ModelDTO>();
		for(ModelProjection model:modelList)
		{
		ModelDTO modelDTO = new ModelDTO();

		modelDTO.setBodyType(model.getBody_Type());
		modelDTO.setModelCaption(model.getModel_Caption());
		modelDTO.setModelDescription(model.getModel_Description());
		modelDTO.setModelId(model.getModel_Id());
		modelDTO.setModelUi(model.getModel_Ui());
		modelDTO.setPartId(model.getPart_Id());
		modelDTOList.add(modelDTO);
		}
		return modelDTOList;
	}

}

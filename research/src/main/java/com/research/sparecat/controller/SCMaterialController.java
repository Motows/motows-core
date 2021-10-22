package com.research.sparecat.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.jobservice.dto.JobTemplateDTO;
import com.research.sparecat.dto.MaterialDTO;
import com.research.sparecat.service.MaterialService;

import io.swagger.annotations.Api;
@Api(description = "Material Controller", tags = { "SpareCat Material" })
@RestController
@RequestMapping("api/Material")
public class SCMaterialController {

	@Autowired
	private MaterialService materialService;

	@PostMapping
	public String addMaterial(@RequestBody MaterialDTO materialDTO) {
		return this.materialService.addMaterial(materialDTO);
	}

	@GetMapping("/{partId}")
	public MaterialDTO getMaterialById(@PathVariable String partId) {
		return this.materialService.getMaterialById(partId);
	}

	@DeleteMapping("/{partId}")
	public String deleteMaterialById(@PathVariable String partId) {
		return this.materialService.deleteMaterialById(partId);
	}

	@PutMapping
	public String updateMaterialById(@RequestBody MaterialDTO materialDTO) {
		return this.materialService.updateMaterialById(materialDTO);
	}
	
//	@GetMapping("/getPartsdetailsWithCategory/{orgID}/{model}/{category}")
//	public List<MaterialDTO> getPartsdetailsWithCategory(@PathVariable("orgID") String orgID,@PathVariable("model") String model,
//			@PathVariable(name="category", required=false)String category) {
//		
//		return this.materialService.getPartsdetailsWithCategory(orgID,model,
//				category);
//	}
}

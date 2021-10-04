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

import com.research.sparecat.dto.OrgMaterialDTO;
import com.research.sparecat.service.OrgMaterialService;

import io.swagger.annotations.Api;
@Api(description = "ORG Material Controller", tags = { "SpareCat Material ORG" })
@RestController
@RequestMapping("api/orgmaterial")
public class SCOrgMaterialController {
	@Autowired
	private OrgMaterialService orgMaterialService;
	
	@PostMapping
	public String addorgmaterial(@RequestBody OrgMaterialDTO orgMaterialDTO) {
		return this.orgMaterialService.addorgmaterial(orgMaterialDTO);
	}

	@GetMapping("/{orgmatId}")
	public OrgMaterialDTO getorgmaterialById(@PathVariable String orgmatId) {
		return this.orgMaterialService.getorgmaterialById(orgmatId);
	}
	
	@GetMapping("/{orgId}/{partID}")
	public List<OrgMaterialDTO> getorgmaterialByOrgIDPartID(@PathVariable String orgId,@PathVariable String partID) {
		return this.orgMaterialService.getorgmaterialByOrgIDPartID(orgId,partID);
	}
	@DeleteMapping("/{orgmatId}")
	public String deleteorgmatialById(@PathVariable String orgmatId) {
		return this.orgMaterialService.deleteorgmatialById(orgmatId);
	}

	@PutMapping
	public String updateorgMaterial(@RequestBody OrgMaterialDTO orgMaterialDTO) {
		return this.orgMaterialService.updateorgMaterial(orgMaterialDTO);
	}

}

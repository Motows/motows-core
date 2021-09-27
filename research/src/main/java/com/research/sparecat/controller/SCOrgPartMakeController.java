package com.research.sparecat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.sparecat.dto.OrgPartMakeDTO;
import com.research.sparecat.service.OrgPartMakeService;

import io.swagger.annotations.Api;
@Api(description = "ORG Part Make Controller", tags = { "SpareCat ORG Part Make" })
@RestController
@RequestMapping("api/orgPartMake")
public class SCOrgPartMakeController {

	@Autowired
	private OrgPartMakeService orgPartMakeService;

	@PostMapping
	public String addOrgPartMake(@RequestBody OrgPartMakeDTO orgPartMakeDTO) {
		return this.orgPartMakeService.addOrgPartMake(orgPartMakeDTO);
	}

	@GetMapping("/{orgPartMakeId}")
	public OrgPartMakeDTO getOrgPartMake(@PathVariable String orgPartMakeId) {
		return this.orgPartMakeService.getOrgPartMake(orgPartMakeId);
	}

	@DeleteMapping("/{orgPartMakeId}")
	public String deleteOrgPartMake(@PathVariable String orgPartMakeId) {
		return this.orgPartMakeService.deleteOrgPartMake(orgPartMakeId);
	}

	@PutMapping
	public String updateOrgPartMakeDTO(@RequestBody OrgPartMakeDTO orgPartMakeDTO) {
		return this.orgPartMakeService.updateOrgPartMakeDTO(orgPartMakeDTO);
	}

}

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

import com.research.sparecat.dto.OrgModelDTO;
import com.research.sparecat.service.OrgModelService;

@RestController
@RequestMapping("api/orgmodel")
public class OrgModelController {
	@Autowired
	private OrgModelService orgmodelService;
	
	@PostMapping
	public String addorgmodel(@RequestBody OrgModelDTO orgmodelDTO) {
		return this.orgmodelService.addorgmodel(orgmodelDTO);
	}

	@GetMapping("/{ModelId}")
	public OrgModelDTO getorgmodelById(@PathVariable String ModelId) {
		return this.orgmodelService.getorgmodelById(ModelId);
	}
	@DeleteMapping("/{ModelId}")
	public String deleteorgmodelById(@PathVariable String ModelId) {
		return this.orgmodelService.deleteorgmodelById(ModelId);
	}

	@PutMapping
	public String updateorgModelById(@RequestBody OrgModelDTO orgmodelDTO) {
		return this.orgmodelService.updateorgModelById(orgmodelDTO);
	}

}
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

import com.research.sparecat.dto.PartMakeDTO;
import com.research.sparecat.service.PartMakeService;

import io.swagger.annotations.Api;
@Api(description = "Part Make Controller", tags = { "SpareCat Part Make" })
@RestController
@RequestMapping("api/partmake")
public class SCPartMakeController {

	@Autowired
	private PartMakeService partmakeService;

	@PostMapping
	public String addPartMake(@RequestBody PartMakeDTO partMakeDTO) {
		return this.partmakeService.addPartMake(partMakeDTO);
	}

	@GetMapping("{partMakeId}")
	public PartMakeDTO getPartMakeById(@PathVariable String partMakeId) {
		return this.partmakeService.getPartMakeById(partMakeId);
	}

	@DeleteMapping("{partMakeId}")
	public String deletePartMake(@PathVariable String partMakeId) {
		return this.partmakeService.deletePartMake(partMakeId);
	}

	@PutMapping
	public String updatePartMake(@RequestBody PartMakeDTO partMakeDTO) {
		return this.partmakeService.updatePartMake(partMakeDTO);
	}

}

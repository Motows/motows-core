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

import com.research.sparecat.dto.HSNDTO;
import com.research.sparecat.service.HSNService;

import io.swagger.annotations.Api;
@Api(description = "HSN Controller", tags = { "SpareCat HSN" })
@RestController
@RequestMapping("api/hsn")
public class SCHSNController {

	@Autowired
	private HSNService HSNService;

	@PostMapping
	public String addhsn(@RequestBody HSNDTO hsndto) {
		return this.HSNService.addhsn(hsndto);
	}

	@GetMapping("/{hsncode}")
	public HSNDTO gethsnbyCode(@PathVariable String hsncode) {
		return this.HSNService.gethsnbyCode(hsncode);
	}

	@DeleteMapping("/{hsncode}")
	public String deletehsnbyCode(@PathVariable String hsncode) {
		return this.HSNService.deletehsnbyCode(hsncode);
	}

	@PutMapping
	public String updatehsn(@RequestBody HSNDTO hsndto) {
		return this.HSNService.updatehsn(hsndto);
	}
}

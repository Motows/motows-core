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

import com.research.sparecat.dto.OrgHSNDTO;
import com.research.sparecat.service.OrgHSNService;

@RestController
@RequestMapping("api/OrgHSN")
public class OrgHSNController {
	@Autowired
	private OrgHSNService OrghsnService;
	
	@PostMapping
	public String addOrghsn(@RequestBody OrgHSNDTO Orghsndto) {
		return this.OrghsnService.addorghsn(Orghsndto);
	}

	@GetMapping("/{hsncode}")
	public OrgHSNDTO getOrgHsnByCode(@PathVariable String hsncode) {
		return this.OrghsnService.gethsnbycode(hsncode);
	}
	@DeleteMapping("/{hsncode}")
	public String deleteorghsn(@PathVariable String hsncode) {
		return this.OrghsnService.deleteorghsn(hsncode);
	}

	@PutMapping
	public String updateOrghsn(@RequestBody OrgHSNDTO Orghsndto) {
		return this.OrghsnService.updatehsn(Orghsndto);
	}

}
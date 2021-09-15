package com.research.jobservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.jobservice.dto.JobTemplateDTO;
import com.research.jobservice.service.JobTemplateService;

@RestController
@RequestMapping("api/jtemplate")
public class JobTemplateController {

	@Autowired
	private JobTemplateService JobTemplateService;
	
	@PostMapping
    public String addjobtemplateDetails(@RequestBody JobTemplateDTO jtdto){
    	return this.JobTemplateService.addjobtemplateDetails(jtdto);
    }
	
	@GetMapping("/getjtbyId/{JobtempId}")
	public JobTemplateDTO getjobtemplatebyId(@PathVariable("JobtempId") String JobtempId) {
		
		return this.JobTemplateService.getjtbyId(JobtempId);
	}
	@DeleteMapping("/deletejobtemplateById/{deleteJtById}")
	public String deleteJobTemplateById(@PathVariable("deleteJtById") String deleteJtById) {
		
		return this.JobTemplateService.deleteJtById(deleteJtById);
	}
	@PostMapping("/updateJTDetails")
	public String updatejobtemplateDetails(@RequestBody JobTemplateDTO jtdto) {
		return this.JobTemplateService.updateJTDetails(jtdto);
	}
	
	
}

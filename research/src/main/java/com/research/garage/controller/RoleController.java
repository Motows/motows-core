package com.research.garage.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.garage.dto.RoleDTO;
import com.research.garage.service.RoleService;

@RestController
@RequestMapping("api/Role")
public class RoleController {

	@Autowired
	private RoleService RoleService;
	
	@PostMapping("/addrole")
    public String addNewRole(@RequestBody RoleDTO role){
    	return this.RoleService.addNewRole(role);
    }
	
	@GetMapping("/getRole/{RoleId}")
	public RoleDTO getRoleById(@PathVariable("RoleId") String RoleId) {
		
		return this.RoleService.getRoleById(RoleId);
	}
	@DeleteMapping("/deleteById/{RoleId}")
	public String deleteRoleById(@PathVariable("RoleId") String RoleId) {
		
		return this.RoleService.deleteRoleById(RoleId);
	}
	@PutMapping("/updateRole")
	public String UpdateRole(@RequestBody RoleDTO RoleId) {
		return this.RoleService.UpdateRole(RoleId);
	}
	
	
}

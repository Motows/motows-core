package com.research.garage.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dto.RoleDTO;
import com.research.garage.iservice.IRoleRepository;


@Component
public class RoleService {

	private final Logger log = LoggerFactory.getLogger(RoleService.class);
	
	@Autowired
	private IRoleRepository roleRepository;
	
	public String addNewRole(RoleDTO role) {
		// TODO Auto-generated method stub
		return this.roleRepository.saveRole(role);
	}

	public RoleDTO getRoleById(String roleId) {
		// TODO Auto-generated method stub
		return this.roleRepository.getRoleById(roleId);
	}

	public String deleteRoleById(String roleId) {
		// TODO Auto-generated method stub
		return this.roleRepository.deleteRoleById(roleId);
	}

	public String UpdateRole(RoleDTO roleId) {
		// TODO Auto-generated method stub
		return	this.roleRepository.UpdateRole(roleId);
	}

	
	
}
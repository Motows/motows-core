package com.research.garage.iservice;
import org.springframework.stereotype.Component;

import com.research.garage.dto.RoleDTO;

@Component
public interface IRoleRepository {

	String saveRole(RoleDTO roleDTO);
	RoleDTO getRoleById(String roleId);
	String deleteRoleById(String roleId);
	String UpdateRole(RoleDTO roleDTO);
	
}
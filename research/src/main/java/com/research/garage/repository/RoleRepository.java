package com.research.garage.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.iservice.IRoleRepository;

import com.research.garage.dao.RoleDAO;
import com.research.garage.dto.RoleDTO;
import com.research.garage.entity.RoleProjection;
@Component
public class RoleRepository implements IRoleRepository {

	@Autowired
	private RoleDAO  RoleDAO;
	

	
	@Override
	public String saveRole(RoleDTO role) {
		RoleProjection rol = new RoleProjection();
			
			rol.setRole_Name(role.getRoleName());
			rol.setRole_Caption(role.getRoleCaption());
			rol.setRoleUI(role.getRoleUI());
			RoleDAO.save(rol);
			return "Role Saved";
		}
	

	@Override
	public RoleDTO getRoleById(String roleId) {
		
		
		RoleProjection rol =	RoleDAO.getOne(roleId);
			
		RoleDTO response = new RoleDTO();

		response.setRoleName(rol.getRole_Name());
		response.setRoleCaption(rol.getRole_Caption());
		response.setRoleUI(rol.getRoleUI());
		response.setRoleId(rol.getRole_Id());
		
		return response;
		}

	@Override
	public String deleteRoleById(String roleId) {
		if(RoleDAO.getOne(roleId)!=null)
		{
			RoleDAO.deleteRoleById(roleId);
			return "deleted";
		}
		else
		{
			return "Role id Not found";
		}
			
	}

	@Override
	public String UpdateRole(RoleDTO roleId) {
		
		RoleProjection rol =	RoleDAO.getOne(roleId.getRoleId());
			
		rol.setRole_Name(roleId.getRoleName());
		rol.setRole_Caption(roleId.getRoleCaption());
		rol.setRoleUI(roleId.getRoleUI());
		rol.setRole_Id(roleId.getRoleId());
			
		RoleDAO.save(rol);
			
			return "updated";
		}

}

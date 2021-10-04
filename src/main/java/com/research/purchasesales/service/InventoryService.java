package com.research.purchasesales.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.purchasesales.dto.InventoryDTO;
import com.research.purchasesales.iservice.IInventoryRepository;




@Component
public class InventoryService {
	@Autowired
	private IInventoryRepository InventoryRepository ;


	public String addInventory(InventoryDTO inventoryDTO) {
		return this.InventoryRepository.saveDetails(inventoryDTO);
	}

	public InventoryDTO getInventoryByID(String inventoryId) {
		return this.InventoryRepository.getInventoryByID(inventoryId);
	}

	public String deleteRoleById(String inventoryId) {
		return this.InventoryRepository.deleteRoleById(inventoryId);
	}

	public String updateInventory(InventoryDTO inventoryDTO) {
		return	this.InventoryRepository.updateInventory(inventoryDTO);
	}

	
	
}
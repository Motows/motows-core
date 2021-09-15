package com.research.purchasesales.iservice;

import com.research.purchasesales.dto.InventoryDTO;

public interface IInventoryRepository {

	String saveDetails(InventoryDTO inventoryDTO);

	InventoryDTO getInventoryByID(String inventoryId);
	
	String deleteRoleById(String inventoryId);

	String updateInventory(InventoryDTO inventoryDTO);

}
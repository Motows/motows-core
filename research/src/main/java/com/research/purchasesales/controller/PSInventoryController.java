package com.research.purchasesales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.purchasesales.dto.InventoryDTO;
import com.research.purchasesales.service.InventoryService;

import io.swagger.annotations.Api;

@Api(description = "Inventory Controller", tags = { "Purchase Sales Inventory" })
@RestController
@RequestMapping("api/Inventory")
public class PSInventoryController {

	@Autowired
	private InventoryService InventoryService;
	
	@PostMapping("/addInventory")
    public String addInventory(@RequestBody InventoryDTO inventoryDTO){
    	return this.InventoryService.addInventory(inventoryDTO);
    }
	
	@GetMapping("/getInventory/{InventoryId}")
	public InventoryDTO getInventoryById(@PathVariable("InventoryId") String InventoryId) {
		
		return this.InventoryService.getInventoryByID(InventoryId);
	}
	@DeleteMapping("/deleteById/{InventoryId}")
	public String deleteInventoryById(@PathVariable("InventoryId") String InventoryId) {
		
		return this.InventoryService.deleteRoleById(InventoryId);
	}
	@PutMapping("/updateInventory")
	public String updateInventory(@RequestBody InventoryDTO inventoryDTO) {
		return this.InventoryService.updateInventory(inventoryDTO);
	}
	
	
}
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

import com.research.purchasesales.dto.PurchaseDTO;
import com.research.purchasesales.dto.PurchaseLineDTO;
import com.research.purchasesales.service.PurchaseLineService;
import com.research.purchasesales.service.PurchaseService;

@RestController
@RequestMapping("api/purchaseline")
public class PurchaseLineController {

	@Autowired
	private PurchaseLineService perchaseLineService;

	@PostMapping
	public String AddPurchaseLine(@RequestBody PurchaseLineDTO purchaseLineDTO) {

		return this.perchaseLineService.AddPurchaseLine(purchaseLineDTO);
	}

	@GetMapping("/{purchaseLineId}")
	public PurchaseLineDTO getPurchaseLineById(@PathVariable String purchaseLineId) {

		return this.perchaseLineService.getPurchaseLineById(purchaseLineId);
	}

	@DeleteMapping("/{purchaseLineId}")
	public String deletePurchaseLineById(@PathVariable String purchaseLineId) {

		return this.perchaseLineService.deletePurchaseLineById(purchaseLineId);
	}

	@PutMapping
	public String updatePurchaseLine(@RequestBody PurchaseLineDTO purchaseLineDTO) {

		return this.perchaseLineService.updatePurchaseLine(purchaseLineDTO);
	}

}

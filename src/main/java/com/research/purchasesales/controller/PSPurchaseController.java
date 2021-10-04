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
import com.research.purchasesales.service.PurchaseService;

import io.swagger.annotations.Api;

@Api(description = "Purchase Controller", tags = { "Purchase Sales Purchase" })
@RestController
@RequestMapping("api/Purchase")
public class PSPurchaseController {

	@Autowired
	private PurchaseService PurchaseService;
	
	@PostMapping("/AddPurchaseRequest")
    public String AddPurchaseRequest(@RequestBody PurchaseDTO purchaseDTO){
    	return this.PurchaseService.AddPurchaseRequest(purchaseDTO);
    }
	
	@GetMapping("/getPurchaseRequest/{purchaseid}")
	public PurchaseDTO getPurchaseRequest(@PathVariable("purchaseid") String purchaseid) {
		
		return this.PurchaseService.getPurchaseRequest(purchaseid);
	}
	@DeleteMapping("/deleteById/{purchaseid}")
	public String deletePurchaseRequestById(@PathVariable("purchaseid") String purchaseid) {
		
		return this.PurchaseService.deleteById(purchaseid);
	}
	@PutMapping("/updatePurchaseReq")
	public String updatePurchaseReq(@RequestBody PurchaseDTO purchaseDTO) {
		return this.PurchaseService.updatePurchaseReq(purchaseDTO);
	}
	
	
}
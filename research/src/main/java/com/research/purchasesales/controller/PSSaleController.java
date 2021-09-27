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

import com.research.purchasesales.dto.SaleDTO;
import com.research.purchasesales.service.SaleService;

import io.swagger.annotations.Api;


@Api(description = "Sale Controller", tags = { "Purchase Sales Sale" })
@RestController
@RequestMapping("api/sale")
public class PSSaleController {

	@Autowired
	private SaleService saleService;

	@PostMapping
	public String saveSale(@RequestBody SaleDTO saleDTO) {

		return this.saleService.saveSale(saleDTO);
	}

	@GetMapping("/{saleId}")
	public SaleDTO getSaleById(@PathVariable String saleId) {

		return this.saleService.getSaleById(saleId);
	}

	@DeleteMapping("/{saleId}")
	public String deleteSaleById(@PathVariable String saleId) {

		return this.saleService.deleteSaleById(saleId);
	}

	@PutMapping
	public String updateSale(@RequestBody SaleDTO saleDTO) {
		return this.saleService.updateSale(saleDTO);
	}

}

package com.research.purchasesales.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.purchasesales.dto.SaleDTO;
import com.research.purchasesales.iservice.ISaleRepository;



@Component
public class SaleService {

	private final Logger log = LoggerFactory.getLogger(SaleService.class);
	
	@Autowired
	private ISaleRepository saleRepository;
	
	

	public String saveSale(SaleDTO saleDTO) {
		
		return this.saleRepository.saveSale(saleDTO);
	}

	
	public SaleDTO getSaleById(String saleId) {
		
		return this.saleRepository.getSaleById(saleId);
	}

	
	public String deleteSaleById(String saleId) {
		
		return this.saleRepository.deleteSaleById(saleId);
	}

	public String updateSale(SaleDTO saleDTO) {
		return this.saleRepository.updateSale(saleDTO);
	}
	

}

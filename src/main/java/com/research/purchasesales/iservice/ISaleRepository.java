package com.research.purchasesales.iservice;

import org.springframework.stereotype.Component;

import com.research.purchasesales.dto.SaleDTO;

@Component
public interface ISaleRepository {

	String saveSale(SaleDTO saleDTO);

	SaleDTO getSaleById(String saleId);

	String deleteSaleById(String saleId);

	String updateSale(SaleDTO saleDTO);

}

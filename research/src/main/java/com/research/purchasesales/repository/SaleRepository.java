package com.research.purchasesales.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.CountryDAO;
import com.research.garage.dao.CustomerDAO;
import com.research.garage.dao.GarageDAO;
import com.research.garage.dao.OrganisationDAO;
import com.research.garage.entity.CountryProjection;
import com.research.garage.entity.CustomerProjection;
import com.research.garage.entity.GarageProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.purchasesales.dao.SaleDAO;
import com.research.purchasesales.dto.SaleDTO;
import com.research.purchasesales.dto.SalesLineDTO;
import com.research.purchasesales.entity.SaleProjection;
import com.research.purchasesales.entity.SalesLineProjection;
import com.research.purchasesales.iservice.ISaleRepository;



@Component
public class SaleRepository implements ISaleRepository {

	@Autowired
	private SaleDAO saleDAO;
	
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private OrganisationDAO organisationDAO;

	@Autowired
	private GarageDAO garageDAO;

	@Override

	public String saveSale(SaleDTO saleDTO) {

		SaleProjection sale = new SaleProjection();
		Date now = new Date();
		OrganisationProjection org = organisationDAO.getOne(saleDTO.getOrganisationId());
		if(org==null)
		{
			return "Organisation ID "+ saleDTO.getOrganisationId() +" not in the Master";
		}
		
		CustomerProjection customer = customerDAO.getOne(saleDTO.getCustomerId());
		if(customer==null)
		{
			return "Customer ID "+ saleDTO.getCustomerId() +" not in the Master";
		}
		
		GarageProjection garage = garageDAO.getOne(saleDTO.getGarageId());
		if(garage==null)
		{
			return "Garage ID "+ saleDTO.getGarageId() +" not in the Master";
		}
		
		sale.setEntry_Type(saleDTO.getEntryType());
		sale.setEntry_Date(now);
		sale.setGarage_Id(saleDTO.getGarageId());
		sale.setJob_No(saleDTO.getJobNo());
		sale.setOrganisation_Id(saleDTO.getOrganisationId());
		sale.setCustomer_Id(saleDTO.getCustomerId());

		saleDAO.save(sale);
		
//		
//
//		for (int i = 0; i < saleDTO.getSalesLIne().size(); i++) {
//
//			SalesLineDTO salesLineDTO = saleDTO.getSalesLIne().get(i);
//
//			
//			SalesLineProjection salesLine = new SalesLineProjection();
//
//			salesLine.setTax(salesLineDTO.getTax());
//			salesLine.setUom(salesLineDTO.getUom());
//			salesLine.setHsn_Or_Sac(salesLineDTO.getHsnOrSac());
//			salesLine.setItemcode(salesLineDTO.getItemcode());
//			salesLine.setPrice(salesLineDTO.getPrice());
//			salesLine.setQty(salesLineDTO.getQty());
//			sale.add(salesLine);
//			salesLine.setSale(sale);
//			salesLineList.add(salesLine);
//
//		}
//		
//		saleDAO.save(sale);
		
//		sale.setSalesLine(salesLineList);
		
//		salesLineDAO.saveAll(salesLineList);
		return "saved";
	}

	@Override
	public SaleDTO getSaleById(String saleId) {

		SaleProjection sale = saleDAO.getOne(saleId);

		SaleDTO saleDTO = new SaleDTO();

		List<SalesLineDTO> salesLineList = new ArrayList<SalesLineDTO>();

		saleDTO.setCustomerId(sale.getCustomer_Id());
		saleDTO.setEntryDate(sale.getEntry_Date());
		saleDTO.setEntryType(sale.getEntry_Type());
		saleDTO.setGarageId(sale.getGarage_Id());
		saleDTO.setJobNo(sale.getJob_No());
		saleDTO.setOrganisationId(sale.getOrganisation_Id());
		saleDTO.setSalesId(sale.getSales_Id());

//		for (int i = 0; i < sale.getSalesLine().size(); i++) {
//
//			SalesLineDTO salesLineDTO = new SalesLineDTO();
//
//			SalesLineProjection salesLine = sale.getSalesLine().get(i);
//
//			salesLineDTO.setSalesLineNo(salesLine.getSales_Line_No());
//			salesLineDTO.setTax(salesLine.getTax());
//			salesLineDTO.setUom(salesLine.getUom());
//			salesLineDTO.setItemcode(salesLine.getItemcode());
//			salesLineDTO.setHsnOrSac(salesLine.getHsn_Or_Sac());
//			salesLineDTO.setPrice(salesLine.getPrice());
//			salesLineDTO.setQty(salesLine.getQty());
//
//			salesLineList.add(salesLineDTO);
//		}
//		saleDTO.setSalesLIne(salesLineList);
		return saleDTO;
	}

	@Override
	public String deleteSaleById(String saleId) {
		saleDAO.deleteById(saleId);
		return "Sale Deleted";
	}

	@Override
	public String updateSale(SaleDTO saleDTO) {

		SaleProjection sale = saleDAO.getOne(saleDTO.getSalesId());
		OrganisationProjection org = organisationDAO.getOne(saleDTO.getOrganisationId());
		if(org==null)
		{
			return "Organisation ID "+ saleDTO.getOrganisationId() +" not in the Master";
		}
		
		CustomerProjection customer = customerDAO.getOne(saleDTO.getCustomerId());
		if(customer==null)
		{
			return "Customer ID "+ saleDTO.getCustomerId() +" not in the Master";
		}
		
		GarageProjection garage = garageDAO.getOne(saleDTO.getGarageId());
		if(garage==null)
		{
			return "Garage ID "+ saleDTO.getGarageId() +" not in the Master";
		}
		sale.setEntry_Type(saleDTO.getEntryType());
	//	sale.setEntry_Date(now);
		sale.setGarage_Id(saleDTO.getGarageId());
		sale.setJob_No(saleDTO.getJobNo());
		sale.setOrganisation_Id(saleDTO.getOrganisationId());
		sale.setCustomer_Id(saleDTO.getCustomerId());
		sale.setSales_Id(saleDTO.getSalesId());




//		for (int i = 0; i < saleDTO.getSalesLIne().size(); i++) {
//			SalesLineDTO salesLineDTO = saleDTO.getSalesLIne().get(i);
//
//			for (int k = 0; k < sale.getSalesLine().size(); k++) {
//
//				SalesLineProjection salesLine = sale.getSalesLine().get(k);
//
//				if (salesLineDTO.getSalesLineNo().equals(salesLine.getSales_Line_No())) {
//
//					salesLine.setTax(salesLineDTO.getTax());
//					salesLine.setUom(salesLineDTO.getUom());
//					salesLine.setHsn_Or_Sac(salesLineDTO.getHsnOrSac());
//					salesLine.setItemcode(salesLineDTO.getItemcode());
//					salesLine.setPrice(salesLineDTO.getPrice());
//					salesLine.setQty(salesLineDTO.getQty());
//
//					sale.add(salesLine);
//				}
//
//			}
//
//		}
		

		saleDAO.save(sale);
		return "Updated";
	}

}

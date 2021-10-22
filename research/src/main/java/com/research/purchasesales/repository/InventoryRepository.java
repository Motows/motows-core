package com.research.purchasesales.repository;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.GarageDAO;

import com.research.garage.dao.OrganisationDAO;
import com.research.garage.entity.CustomerProjection;
import com.research.garage.entity.GarageProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.purchasesales.dao.InventoryDAO;
import com.research.purchasesales.dto.InventoryDTO;
import com.research.purchasesales.entity.InventoryProjection;
import com.research.purchasesales.iservice.IInventoryRepository;


@Component
public class InventoryRepository implements IInventoryRepository{
	@Autowired
	private GarageDAO garageDAO;
	
	@Autowired
	private OrganisationDAO OrganisationDAO;
	
	@Autowired
	private InventoryDAO InventoryDAO;
	@Override
	public String saveDetails(InventoryDTO inventoryDTO) {
		OrganisationProjection org = OrganisationDAO.getOne(inventoryDTO.getOrgId());
		if(org==null)
		{
			return "Organisation ID "+ inventoryDTO.getOrgId() +" not in the Master";
		}
		
		GarageProjection garage = garageDAO.getOne(inventoryDTO.getGarageID());
		if(garage==null)
		{
			return "Garage ID "+ inventoryDTO.getGarageID() +" not in the Master";
		}
		
		Date now = new Date();
		
		InventoryProjection invpro = new InventoryProjection();
		
		invpro.setItem_Code(inventoryDTO.getItemCode());
		invpro.setStockin(inventoryDTO.getStockin());
		invpro.setStockout(inventoryDTO.getStockout());
		invpro.setPurprices(inventoryDTO.getPurprices());
		invpro.setSalesprice(inventoryDTO.getSalesprice());
		invpro.setReferencetransaction(inventoryDTO.getReferencetransaction());
		invpro.setOrg_Id(inventoryDTO.getOrgId());
		invpro.setGarageId(inventoryDTO.getGarageID());
		invpro.setEntry_Date(now);
		//invpro.setOrganisation(null);
		//invpro.setOrganisation(organisation);
		//invpro.setGarage(garagepro);
		InventoryDAO.save(invpro);
		return "Inventory Saved";

		
	}

	@Override
	public InventoryDTO getInventoryByID(String inventoryId) {
		InventoryProjection inv =	InventoryDAO.getOne(inventoryId);
		
		InventoryDTO invdto = new InventoryDTO();
		
		invdto.setEntryDate(inv.getEntry_Date());
		invdto.setItemCode(inv.getItem_Code());
		invdto.setOrgId(inv.getOrg_Id());
		invdto.setEntryno(inv.getEntryno());
		invdto.setStockin(inv.getStockin());
		invdto.setStockout(inv.getStockout());
		invdto.setPurprices(inv.getPurprices());
		invdto.setSalesprice(inv.getSalesprice());
		invdto.setReferencetransaction(inv.getReferencetransaction());
		invdto.setGarageID(inv.getGarageId());
		return invdto;
	}

	@Override
	public String deleteRoleById(String inventoryId) {
		InventoryDAO.deleteById(inventoryId);
		
		return "deleted";
	}

	@Override
	public String updateInventory(InventoryDTO inventoryDTO) {

		InventoryProjection invpro =	InventoryDAO.getOne(inventoryDTO.getEntryno());
		
		
		OrganisationProjection org = OrganisationDAO.getOne(inventoryDTO.getOrgId());
		if(org==null)
		{
			return "Organisation ID "+ inventoryDTO.getOrgId() +" not in the Master";
		}
		
		GarageProjection garage = garageDAO.getOne(inventoryDTO.getGarageID());
		if(garage==null)
		{
			return "Garage ID "+ inventoryDTO.getGarageID() +" not in the Master";
		}
		
		Date now = new Date();
		
		invpro.setItem_Code(inventoryDTO.getItemCode());
		invpro.setStockin(inventoryDTO.getStockin());
		invpro.setStockout(inventoryDTO.getStockout());
		invpro.setPurprices(inventoryDTO.getPurprices());
		invpro.setSalesprice(inventoryDTO.getSalesprice());
		invpro.setReferencetransaction(inventoryDTO.getReferencetransaction());
		invpro.setOrg_Id(inventoryDTO.getOrgId());
		invpro.setGarageId(inventoryDTO.getGarageID());

		InventoryDAO.save(invpro);

		return "updated";
	}

}
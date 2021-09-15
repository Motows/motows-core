package com.research.purchasesales.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.purchasesales.dto.PurchaseDTO;
import com.research.purchasesales.dto.PurchaseLineDTO;
import com.research.purchasesales.entity.PurchaseLineProjection;
import com.research.purchasesales.entity.PurchaseProjection;
import com.research.garage.dao.GarageDAO;
import com.research.garage.entity.GarageProjection;
import com.research.purchasesales.dao.PurchaseDAO;
import com.research.purchasesales.dao.PurchaseLineDAO;
import com.research.purchasesales.iservice.IPurchaseRepository;



@Component
public class PurchaseRepository implements IPurchaseRepository {
	@Autowired
	private PurchaseDAO PurchaseDAO;
	@Autowired
	private PurchaseLineDAO PurchaseLineDAO;
	@Autowired
	private GarageDAO garageDAO;

	@Override
	public String AddPurchaseRequest(PurchaseDTO purchaseDTO) {
		GarageProjection garagepro = garageDAO.getOne(purchaseDTO.getGarageID());
		Date now = new Date();

		PurchaseProjection PurchasePro = new PurchaseProjection();

		PurchasePro.setEntry_Type(purchaseDTO.getEntryType());
		PurchasePro.setOrganisationID(purchaseDTO.getOrganisationID());
		PurchasePro.setVendorID(purchaseDTO.getVendorID());
		PurchasePro.setEntry_Date(now);
		PurchasePro.setSupplierrefno(purchaseDTO.getSupplierrefno());
		PurchasePro.setSupplierref_Posting_Date(now);
		PurchasePro.setJobno(purchaseDTO.getJobno());
	//	PurchasePro.setGarage(garagepro);

		PurchaseDAO.save(PurchasePro);
		List<PurchaseLineProjection> purchaselineLineList = new ArrayList<PurchaseLineProjection>();
		for (int i = 0; i < purchaseDTO.getPurchaseline().size(); i++) {

			PurchaseLineDTO prchaselinedto = purchaseDTO.getPurchaseline().get(i);

			PurchaseLineProjection purchaseLine = new PurchaseLineProjection();
			purchaseLine.setHSN(prchaselinedto.getHSN());
			purchaseLine.setItemcode(prchaselinedto.getItemcode());
			purchaseLine.setPrice(prchaselinedto.getPrice());
			purchaseLine.setPurchaselineno(prchaselinedto.getPurchaselineno());
			purchaseLine.setQty(prchaselinedto.getQty());
			purchaseLine.setTax(prchaselinedto.getTax());
			purchaseLine.setUom(prchaselinedto.getUom());
			purchaseLine.setPurchase(PurchasePro);
			purchaselineLineList.add(purchaseLine);

		}
		PurchaseLineDAO.saveAll(purchaselineLineList);
		return "PurchaseRequest Saved";
	}

	@Override
	public PurchaseDTO getPurchaseRequest(String purchaseid) {
		PurchaseProjection PurchasePro = PurchaseDAO.getOne(purchaseid);

		PurchaseDTO response = new PurchaseDTO();

		List<PurchaseLineDTO> purchaseLineList = new ArrayList<PurchaseLineDTO>();

		response.setPurcahseID(PurchasePro.getPurcahseID());
		response.setEntryType(PurchasePro.getEntry_Type());
		response.setOrganisationID(PurchasePro.getOrganisationID());
		response.setVendorID(PurchasePro.getVendorID());
		response.setEntryDate(PurchasePro.getEntry_Date());
		response.setSupplierrefno(PurchasePro.getSupplierrefno());
		response.setSupplierrefPostingDate(PurchasePro.getSupplierref_Posting_Date());
		response.setJobno(PurchasePro.getJobno());
	//	response.setGarageID(PurchasePro.getGarage().getGarageId());

		for (int i = 0; i < PurchasePro.getPurchaseline().size(); i++) {
			PurchaseLineDTO prchaselinedto = new PurchaseLineDTO();
			PurchaseLineProjection purchaseLine = PurchasePro.getPurchaseline().get(i);
			prchaselinedto.setHSN(purchaseLine.getHSN());
			prchaselinedto.setItemcode(purchaseLine.getItemcode());
			prchaselinedto.setPrice(purchaseLine.getPrice());
			prchaselinedto.setPurchaselineno(purchaseLine.getPurchaselineno());
			prchaselinedto.setQty(purchaseLine.getQty());
			prchaselinedto.setTax(purchaseLine.getTax());
			prchaselinedto.setUom(purchaseLine.getUom());
			prchaselinedto.setPurcahseLineId(purchaseLine.getPurcahse_Line_Id());

			purchaseLineList.add(prchaselinedto);

		}

		response.setPurchaseline(purchaseLineList);
		return response;
	}

	@Override
	public String deleteById(String purchaseid) {
		PurchaseDAO.deleteById(purchaseid);

		return "deleted";
	}

	@Override
	public String updatePurchaseReq(PurchaseDTO purchaseDTO) {

		PurchaseProjection PurchasePro = PurchaseDAO.getOne(purchaseDTO.getPurcahseID());

		PurchasePro.setEntry_Type(purchaseDTO.getEntryType());
		PurchasePro.setOrganisationID(purchaseDTO.getOrganisationID());
		PurchasePro.setVendorID(purchaseDTO.getVendorID());
		PurchasePro.setSupplierrefno(purchaseDTO.getSupplierrefno());
		PurchasePro.setJobno(purchaseDTO.getJobno());
		List<PurchaseLineProjection> purchaseLinelist = new ArrayList<PurchaseLineProjection>();
		for (int i = 0; i < purchaseDTO.getPurchaseline().size(); i++) {
			PurchaseLineDTO dto = purchaseDTO.getPurchaseline().get(i);
			for (int k = 0; k < PurchasePro.getPurchaseline().size(); k++) {

				PurchaseLineProjection purchaseline = PurchasePro.getPurchaseline().get(k);
				if (dto.getPurchaselineno().equals(purchaseline.getPurchaselineno())) {

					purchaseline.setHSN(dto.getHSN());
					purchaseline.setItemcode(dto.getItemcode());
					purchaseline.setPrice(dto.getPrice());
					purchaseline.setPurchaselineno(dto.getPurchaselineno());
					purchaseline.setQty(dto.getQty());
					purchaseline.setTax(dto.getTax());
					purchaseline.setUom(dto.getUom());
					purchaseLinelist.add(purchaseline);
				}
			}
		}
		PurchasePro.setPurchaseline(purchaseLinelist);
		PurchaseDAO.save(PurchasePro);

		return "Updated";
	}
}

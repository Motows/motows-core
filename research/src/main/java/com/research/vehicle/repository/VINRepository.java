package com.research.vehicle.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.vehicle.dto.VINDTO;
import com.research.garage.dao.CustomerDAO;
import com.research.garage.entity.CustomerProjection;
import com.research.vehicle.dao.ColorDAO;
import com.research.vehicle.dao.ModelDAO;
import com.research.vehicle.dao.VINDAO;
import com.research.vehicle.dao.VinContactDAO;
import com.research.vehicle.entity.ColorProjection;
import com.research.vehicle.entity.ModelProjection;
import com.research.vehicle.entity.VINProjection;
import com.research.vehicle.entity.VIN_ContactProjection;
import com.research.vehicle.iservice.IVINRepository;

@Component
public class VINRepository implements IVINRepository {
	@Autowired
	private VINDAO VINDAO;

	@Autowired
	private ModelDAO modelDAO;

	@Autowired
	private ColorDAO colorDAO;

	@Autowired
	private VinContactDAO vinContactDAO;
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public String AddVinDetails(VINDTO vindto) {

		CustomerProjection customer=customerDAO.getOne(vindto.getCustomerId());
		if(customer==null)
		{
			return "Customer ID Not Matching or Detail Not Available";
		}
		
		ModelProjection model = modelDAO.getOne(vindto.getModelID());
		if(model==null)
		{
			return "Model ID "+ vindto.getModelID() +" not Matching";
		}
		ColorProjection color = colorDAO.getOne(vindto.getColorID());
		if(color==null)
		{
			return "Color ID "+ vindto.getColorID() +" not Matching";
		}
	//	VIN_ContactProjection vinContact = vinContactDAO.getOne(vindto.getVehicleID());
		VIN_ContactProjection vinProj = new VIN_ContactProjection();
		vinProj.setVehicleID(vindto.getVINRegNo());
		vinProj.setContact_Type(vindto.getContactType());
		vinProj.setCustomer_Id(vindto.getCustomerId());
		VIN_ContactProjection result =vinContactDAO.save(vinProj);
		
		VINProjection vinpro = new VINProjection();
		vinpro.setVINReg_No(vindto.getVINRegNo());
		vinpro.setVINNo(vindto.getVINNo());
		vinpro.setModel(model);
		vinpro.setManufacture_Year(vindto.getManufactureYear());
		vinpro.setColor(color);
	//	vinpro.setVinContact(vinContact);
		vinpro.setVehicle_Notes(vindto.getVehicleNotes());
		vinpro.setVinContact(result);
		VINDAO.save(vinpro);
		
		return "vin details added";
	}

	@Override
	public VINDTO getvinByID(String vinId) {

		VINProjection vinpro = VINDAO.getOne(vinId);

		VINDTO vindto = new VINDTO();
		if(vinpro==null)
		{
			vindto.setVehicleID("Invalid ID:"+vinId);
			return vindto;
		}
		vindto.setVINRegNo(vinpro.getVINReg_No());
		vindto.setVINNo(vinpro.getVINNo());
		vindto.setModelID(vinpro.getModel().getModel_Id());
		vindto.setManufactureYear(vinpro.getManufacture_Year());
		vindto.setColorID(vinpro.getColor().getColor_Id());
		vindto.setVehicleNotes(vinpro.getVehicle_Notes());
		vindto.setVehicleID(vinpro.getVINReg_No());
		vindto.setContactType(vinpro.getVinContact().getContact_Type());
		vindto.setCustomerId(vinpro.getVinContact().getCustomer_Id());
		return vindto;
	}

	@Override
	public String deleteVinByID(String vinId) {
		if(VINDAO.getOne(vinId)!=null)
		{
			VINDAO.deleteById(vinId);

			return "Vehicle deleted";
		}
		else
		{
			return "Vehicle id Not found";
		}

	
	}

	@Override
	public String updateVinDetails(VINDTO vindto) {
		
		ModelProjection model = modelDAO.getOne(vindto.getModelID());
		if(model==null)
		{
			return "Model ID "+ vindto.getModelID() +" not Matching";
		}
		ColorProjection color = colorDAO.getOne(vindto.getColorID());
		if(color==null)
		{
			return "Color ID "+ vindto.getColorID() +" not Matching";
		}

		VINProjection vinpro = VINDAO.getOne(vindto.getVehicleID());
		vinpro.setVINReg_No(vindto.getVINRegNo());
		vinpro.setVINNo(vindto.getVINNo());
		vinpro.setModel(model);
		vinpro.setManufacture_Year(vindto.getManufactureYear());
		vinpro.setColor(color);
		vinpro.setVehicle_Notes(vindto.getVehicleNotes());
		vinpro.setVINReg_No(vindto.getVINRegNo());
		VINDAO.save(vinpro);
		return "Updated successfully";
	}

}

package com.research.vehicle.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.vehicle.dto.VinContactDTO;
import com.research.garage.dao.CustomerDAO;
import com.research.garage.entity.CustomerProjection;
import com.research.vehicle.dao.VinContactDAO;
import com.research.vehicle.entity.VIN_ContactProjection;
import com.research.vehicle.iservice.IVinContactRepository;

@Component
public class VinContactRepository implements IVinContactRepository {
	@Autowired
	private VinContactDAO VinContactDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public String AddVinConDetails(VinContactDTO vinContactDTO) {
		
		CustomerProjection customer = customerDAO.getOne(vinContactDTO.getCustomerID());

		VIN_ContactProjection vinconpro = new VIN_ContactProjection();
	//	vinconpro.setContactType(vinContactDTO.getContactType());
	//	vinconpro.setCustomer(customer);

		VinContactDAO.save(vinconpro);
		return "vin Contacts details saved";
	}

	@Override
	public VinContactDTO getvinConByID(String vehicleId) {
		VIN_ContactProjection vinconpro = VinContactDAO.getOne(vehicleId);
		VinContactDTO vincondto = new VinContactDTO();
		if(vinconpro==null)
		{
			vincondto.setVehicleID("Invalid ID:"+vehicleId);
			return vincondto;
		}
		vincondto.setContactType(vinconpro.getContact_Type());
		vincondto.setCustomerID(vinconpro.getCustomer_Id());
		vincondto.setVehicleID(vinconpro.getVehicleID());
		return vincondto;
	}

	@Override
	public String deleteVinConByID(String vehicleId) {
		if(VinContactDAO.getOne(vehicleId)!=null)
		{
			VinContactDAO.deleteById(vehicleId);

			return "Vehicle Contact deleted";
		}
		else
		{
			return "Vehicle Contact  id Not found";
		}

	}

	@Override
	public String updateVinConDetails(VinContactDTO vinContactDTO) {

		VIN_ContactProjection vinconpro = VinContactDAO.getOne(vinContactDTO.getVehicleID());
		CustomerProjection customer = customerDAO.getOne(vinContactDTO.getCustomerID());

	//	vinconpro.setContactType(vinContactDTO.getContactType());
	//	vinconpro.setCustomer(customer);
		vinconpro.setVehicleID(vinContactDTO.getVehicleID());
		VinContactDAO.save(vinconpro);
		return "Updated successfully";
	}


}

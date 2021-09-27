package com.research.garage.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.CountryDAO;
import com.research.garage.dao.StateDAO;
import com.research.garage.dao.ZipCodeDAO;
import com.research.garage.dao.OrganisationDAO;
import com.research.garage.dao.VendorDAO;
import com.research.garage.dto.VendorDTO;
import com.research.garage.entity.CountryProjection;
import com.research.garage.entity.OrganisationProjection;
import com.research.garage.entity.StateProjection;
import com.research.garage.entity.VendorProjection;
import com.research.garage.entity.ZipCodeProjection;
import com.research.garage.iservice.IVendorRepository;

@Component
public class VendorRepository implements IVendorRepository {
	@Autowired
	private VendorDAO  VendorDAO;
	
	@Autowired
	private ZipCodeDAO ZipCodeDAO;
	
	@Autowired
	private CountryDAO countryDAO;
	
	@Autowired
	private StateDAO stateDAO;
	
	@Autowired
	private OrganisationDAO OrganisationDAO;

	@Override
	public String savevendordetails(VendorDTO vendorDTO) {
		CountryProjection country = countryDAO.getOne(vendorDTO.getCountryId());
		StateProjection state =  stateDAO.getOne(vendorDTO.getStateId());
		OrganisationProjection org = OrganisationDAO.getOne(vendorDTO.getOrgId());
		ZipCodeProjection zipCode = ZipCodeDAO.getOne(vendorDTO.getZipCodeId());
		
		if(org==null)
		{
			return "Org ID "+ vendorDTO.getOrgId() +" not in the Master";
		}
		
		if(zipCode==null)
		{
			return "ZipCode ID "+ vendorDTO.getZipCodeId() +" not in the Master";
		}
		else
		{
			vendorDTO.setCountryId(zipCode.getCountry_Id());
			vendorDTO.setStateId(zipCode.getState_Id());
		}
		
//		if(country==null)
//		{
//			return "Country ID "+ vendorDTO.getCountryId() +" not in the Master";
//		}
//		if(state==null)
//		{
//			return "State ID "+ vendorDTO.getStateId() +" not in the Master";
//		}
		
		
		VendorProjection vendor = new VendorProjection();
		vendor.setVendorID(vendorDTO.getVendorID());
		vendor.setVendor_Name(vendorDTO.getVendorName());
		vendor.setVendor_Name_Caption(vendorDTO.getVendorNameCaption());
		vendor.setVendor_NameUI(vendorDTO.getVendorNameUI());
		vendor.setType(vendorDTO.getType());
		vendor.setEmailID(vendorDTO.getEmailID());
		vendor.setAddress(vendorDTO.getAddress());
		vendor.setEmailIDVerified(vendorDTO.getEmailIDVerified());
		vendor.setMobile_No_Verified(vendorDTO.getMobileNoVerified());
		vendor.setGSTIN(vendorDTO.getGSTIN());
		vendor.setCountry_Id(vendorDTO.getCountryId());
		vendor.setState_Id(vendorDTO.getStateId());
		vendor.setOrg_Id(vendorDTO.getOrgId());
		vendor.setZip_Code_Id(vendorDTO.getZipCodeId());
		VendorDAO.save(vendor);
		return "Details Saved";
	}

	@Override
	public VendorDTO getVendorById(String vendorId) {

		VendorProjection ven =	VendorDAO.getOne(vendorId);
			
		VendorDTO response = new VendorDTO();

		response.setVendorID(ven.getVendorID());
		response.setVendorName(ven.getVendor_Name());
		response.setVendorNameCaption(ven.getVendor_Name_Caption());
		response.setVendorNameUI(ven.getVendor_NameUI());
		response.setType(ven.getType());
		response.setEmailID(ven.getEmailID());
		response.setAddress(ven.getAddress());
		response.setEmailIDVerified(ven.getEmailIDVerified());
		response.setMobileNoVerified(ven.getMobile_No_Verified());
		response.setGSTIN(ven.getGSTIN());
		
		return response;
	}
	
	@Override
	public List<VendorDTO> getVendorByOrgID(String orgId) {

		List<VendorProjection> venList =	VendorDAO.getVendorByOrgID(orgId);
		List<VendorDTO> venDtoList = new ArrayList<VendorDTO>();
		for(VendorProjection ven:venList)
		{
		VendorDTO response = new VendorDTO();
		response.setVendorID(ven.getVendorID());
		response.setVendorName(ven.getVendor_Name());
		response.setVendorNameCaption(ven.getVendor_Name_Caption());
		response.setVendorNameUI(ven.getVendor_NameUI());
		response.setType(ven.getType());
		response.setEmailID(ven.getEmailID());
		response.setAddress(ven.getAddress());
		response.setEmailIDVerified(ven.getEmailIDVerified());
		response.setMobileNoVerified(ven.getMobile_No_Verified());
		response.setGSTIN(ven.getGSTIN());
		response.setCountryId(ven.getCountry_Id());
		response.setStateId(ven.getState_Id());
		response.setZipCodeId(ven.getZip_Code_Id());
		
		venDtoList.add(response);
		}
		return venDtoList;
	}

	@Override
	public String deleteVendorByID(String vendorId) {
		VendorDAO.deleteById(vendorId);
		
		return "deleted";
	}

	@Override
	public String updateVenorDetails(VendorDTO vendorDTO) {
		VendorProjection ven =	VendorDAO.getOne(vendorDTO.getVendorID());

		ven.setVendorID(vendorDTO.getVendorID());
		ven.setVendor_Name(vendorDTO.getVendorName());
		ven.setVendor_Name_Caption(vendorDTO.getVendorNameCaption());
		ven.setVendor_NameUI(vendorDTO.getVendorNameUI());
		ven.setType(vendorDTO.getType());
		ven.setEmailID(vendorDTO.getEmailID());
		ven.setAddress(vendorDTO.getAddress());
		ven.setEmailIDVerified(vendorDTO.getEmailIDVerified());
		ven.setMobile_No_Verified(vendorDTO.getMobileNoVerified());
		ven.setGSTIN(vendorDTO.getGSTIN());
		VendorDAO.save(ven);
		return "updated";
	}

	
}


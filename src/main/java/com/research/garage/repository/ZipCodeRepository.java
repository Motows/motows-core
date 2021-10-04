package com.research.garage.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.CountryDAO;
import com.research.garage.dao.StateDAO;
import com.research.garage.dao.ZipCodeDAO;
import com.research.garage.dto.ZipCodeDTO;
import com.research.garage.entity.CountryProjection;
import com.research.garage.entity.StateProjection;
import com.research.garage.entity.ZipCodeProjection;
import com.research.garage.iservice.IZipCodeRepository;


@Component
public class ZipCodeRepository implements IZipCodeRepository {

	@Autowired
	private ZipCodeDAO ZipCodeDAO;

	@Autowired
	private CountryDAO countryDAO;

	@Autowired
	private StateDAO stateDAO;

	@Override
	public String saveZipCode(ZipCodeDTO zipCodeDTO) {

		CountryProjection country = countryDAO.getOne(zipCodeDTO.getCountryId());
		StateProjection state = stateDAO.getOne(zipCodeDTO.getStateId());
		ZipCodeProjection zipCode = new ZipCodeProjection();
		if(zipCodeDTO.getZipCodeId()==null||zipCodeDTO.getZipCodeId().isEmpty())
		{
			return "Zip Code  "+ zipCodeDTO.getZipCodeId() +" Should Not Be Empty";
		}
		ZipCodeProjection zipCode1 = ZipCodeDAO.getOne(zipCodeDTO.getZipCodeId());
		if(zipCode1!=null)
		{
			return "Zip Code  "+ zipCodeDTO.getZipCodeId() +" Already Available";
		}
		if(country==null)
		{
			return "Country ID "+ zipCodeDTO.getCountryId() +" not in the Master";
		}
		if(state==null)
		{
			return "State ID "+ zipCodeDTO.getStateId() +" not in the Master";
		}
		
		
		zipCode.setZip_Code_Id(zipCodeDTO.getZipCodeId());
		zipCode.setCity_Name(zipCodeDTO.getCityName());
		zipCode.setCountry_Id(zipCodeDTO.getCountryId());
		zipCode.setState_Id(zipCodeDTO.getStateId());

		ZipCodeDAO.save(zipCode);

		return "ZipCode Saved";
	}

	@Override
	public ZipCodeDTO getZipCodeById(String ZipCodeId) {

		ZipCodeProjection zipCode = ZipCodeDAO.getOne(ZipCodeId);

		ZipCodeDTO zipCodeDTO = new ZipCodeDTO();

		zipCodeDTO.setCityName(zipCode.getCity_Name());
		zipCodeDTO.setZipCodeId(zipCode.getZip_Code_Id());
		zipCodeDTO.setStateId(zipCode.getState_Id());
		zipCodeDTO.setCountryId(zipCode.getCountry_Id());

		return zipCodeDTO;
	}

	@Override
	public String deleteZipCodeById(String ZipCodeId) {
		ZipCodeDAO.deleteById(ZipCodeId);
		return "ZipCode Deleted";
	}

	@Override
	public String UpdateZipCode(ZipCodeDTO ZipCodeDTO) {
		ZipCodeProjection zipCode = ZipCodeDAO.getOne(ZipCodeDTO.getZipCodeId());

		zipCode.setCity_Name(ZipCodeDTO.getCityName());

		return "ZipCode Updated";
	}

	@Override
	public List<ZipCodeDTO> getAllZipCodes() {
		List<ZipCodeProjection> allZipCodes = ZipCodeDAO.getAll();
		List<ZipCodeDTO> allZipCodesDTO = new ArrayList<ZipCodeDTO>();
		for (ZipCodeProjection zipCode : allZipCodes) {
			ZipCodeDTO zipCodeDTO = new ZipCodeDTO();
			zipCodeDTO.setStateId(zipCode.getState_Id());
			zipCodeDTO.setCountryId(zipCode.getCountry_Id());
			zipCodeDTO.setCityName(zipCode.getCity_Name());
			zipCodeDTO.setZipCodeId(zipCode.getZip_Code_Id());

			allZipCodesDTO.add(zipCodeDTO);

		}
		return allZipCodesDTO;
	}
	
	@Override
	public List<ZipCodeDTO> getListForCountry(String countryId) {
		List<ZipCodeProjection> allZipCodes = ZipCodeDAO.getListForCountry(countryId);
		List<ZipCodeDTO> allZipCodesDTO = new ArrayList<ZipCodeDTO>();
		for (ZipCodeProjection zipCode : allZipCodes) {
			ZipCodeDTO zipCodeDTO = new ZipCodeDTO();
			zipCodeDTO.setStateId(zipCode.getState_Id());
			zipCodeDTO.setCountryId(zipCode.getCountry_Id());
			zipCodeDTO.setCityName(zipCode.getCity_Name());
			zipCodeDTO.setZipCodeId(zipCode.getZip_Code_Id());

			allZipCodesDTO.add(zipCodeDTO);

		}
		return allZipCodesDTO;
	}

}

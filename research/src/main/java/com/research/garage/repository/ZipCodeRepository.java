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
		zipCode.setZip_Code_Id(zipCodeDTO.getZipCodeId());
		zipCode.setCity_Name(zipCodeDTO.getCityName());
		zipCode.setCountry(country);
		zipCode.setState(state);

		ZipCodeDAO.save(zipCode);

		return "ZipCode Saved";
	}

	@Override
	public ZipCodeDTO getZipCodeById(String ZipCodeId) {

		ZipCodeProjection zipCode = ZipCodeDAO.getOne(ZipCodeId);

		ZipCodeDTO zipCodeDTO = new ZipCodeDTO();

		zipCodeDTO.setCityName(zipCode.getCity_Name());
		zipCodeDTO.setZipCodeId(zipCode.getZip_Code_Id());
		zipCodeDTO.setStateId(zipCode.getState().getState_Id());
		zipCodeDTO.setCountryId(zipCode.getCountry().getCountryID());

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
		List<ZipCodeProjection> allZipCodes = ZipCodeDAO.findAll();
		List<ZipCodeDTO> allZipCodesDTO = new ArrayList<ZipCodeDTO>();
		for (ZipCodeProjection zipCode : allZipCodes) {
			ZipCodeDTO zipCodeDTO = new ZipCodeDTO();
			zipCodeDTO.setStateId(zipCode.getState().getState_Id());
			zipCodeDTO.setCountryId(zipCode.getCountry().getCountryID());
			zipCodeDTO.setCityName(zipCode.getCity_Name());
			zipCodeDTO.setZipCodeId(zipCode.getZip_Code_Id());

			allZipCodesDTO.add(zipCodeDTO);

		}
		return allZipCodesDTO;
	}

}

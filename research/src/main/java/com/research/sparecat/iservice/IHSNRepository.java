package com.research.sparecat.iservice;

import com.research.sparecat.dto.HSNDTO;

public interface IHSNRepository {

	String addhsn(HSNDTO hsndto);

	HSNDTO gethsnbyCode(String hsncode);

	String deletehsnbyCode(String hsncode);

	String updatehsn(HSNDTO hsndto);
	

}

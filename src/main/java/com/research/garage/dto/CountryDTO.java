package com.research.garage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class CountryDTO {


	private String CountryID;

	private String CountryShortName;

	private String CountryShortNameCaption;

	private String CountryShortNameUI;

	private String CountryLongName;

	private String CountryLongNameCaption;

	private String CountryLongNameUI;
}

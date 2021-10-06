package com.research.research.inputadapters.web;
import java.util.ArrayList;
import java.util.List;

import com.research.purchasesales.dto.PurchaseDTO;
import com.research.purchasesales.dto.PurchaseLineDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class PurchaseDetailsDTO {
	PurchaseDTO purchase=new PurchaseDTO();
	List<PurchaseLineDTO> purchaseLine=new ArrayList<PurchaseLineDTO>();
	
}	

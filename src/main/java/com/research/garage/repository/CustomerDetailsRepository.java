package com.research.garage.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.research.garage.dao.CustomerDetailsDAO;
import com.research.garage.dto.CustomerOrderDTO;
import com.research.garage.entity.CustomerDetailsProjection;
import com.research.garage.entity.ItemsProjection;
import com.research.garage.iservice.ICustomerDetailsRepository;

@Component
public class CustomerDetailsRepository implements ICustomerDetailsRepository {

	@Autowired
	private CustomerDetailsDAO customerDAO;

	@Override
	public CustomerOrderDTO saveCustomerDetails(CustomerOrderDTO customerOrderDTO) {

		Date now = new Date();

		CustomerDetailsProjection cusd = new CustomerDetailsProjection();
		cusd.setCustomerName(customerOrderDTO.getCustomerName());
		cusd.setCustomerMobile(customerOrderDTO.getCustomerMobile());
		cusd.setMailId(customerOrderDTO.getMailId());
		cusd.setDocumentDate(now);
		customerDAO.save(cusd);

		for (int i = 0; i < customerOrderDTO.getItems().size(); i++) {

			ItemsProjection theItems = customerOrderDTO.getItems().get(i);

			cusd.add(theItems);
		}

		customerDAO.save(cusd);
		return customerOrderDTO;
	}

	@Override
	public CustomerOrderDTO getItemsByCustomerId(Long customerId) {
		CustomerDetailsProjection cus = customerDAO.getOne(customerId);
		
		CustomerOrderDTO crDto = new CustomerOrderDTO();
		crDto.setId(cus.getDocumentNo());
		crDto.setCustomerName(cus.getCustomerName());
		crDto.setCustomerMobile(cus.getCustomerMobile());
		crDto.setMailId(cus.getMailId());
		crDto.setDocumentDate(cus.getDocumentDate());
		
		

		List<ItemsProjection> itemList = new ArrayList<ItemsProjection>();
		for (int i = 0; i < cus.getItems().size(); i++) {

			ItemsProjection itemDetails = new ItemsProjection();

			itemDetails.setId(cus.getItems().get(i).getId());
			itemDetails.setItemName(cus.getItems().get(i).getItemName());
			itemDetails.setPrice(cus.getItems().get(i).getPrice());
			itemDetails.setQuantity(cus.getItems().get(i).getQuantity());
			itemDetails.setItemTotal(cus.getItems().get(i).getItemTotal());

			itemList.add(itemDetails);
		}

		crDto.setItems(itemList);

		return crDto;
	}

	@Override
	public CustomerOrderDTO deleteCustomerById(Long customerId) {
		customerDAO.deleteById(customerId);
		return null;
	}

	@Override
	public CustomerOrderDTO UpdateCustomer(CustomerOrderDTO customerOrderDTO) {
		CustomerDetailsProjection customer = customerDAO.getOne(customerOrderDTO.getId());

		customer.setCustomerName(customerOrderDTO.getCustomerName());
		customer.setCustomerMobile(customerOrderDTO.getCustomerMobile());
		customer.setMailId(customerOrderDTO.getMailId());

		for (int i = 0; i < customer.getItems().size(); i++) {
			ItemsProjection itemDetails = customer.getItems().get(i);
			Long id1 = itemDetails.getId();

			for (int j = 0; j < customerOrderDTO.getItems().size(); j++) {
				ItemsProjection dto = customerOrderDTO.getItems().get(j);
				Long id2 = dto.getId();
				if (id1 == id2) {
					itemDetails.setItemName(dto.getItemName());
					itemDetails.setPrice(dto.getPrice());
					itemDetails.setQuantity(dto.getQuantity());
					itemDetails.setItemTotal(dto.getItemTotal());

				}

			}
		}

		customerDAO.save(customer);

		return null;
	}

}

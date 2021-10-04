package com.research.garage.dto;

import java.util.Date;
import java.util.List;

import com.research.garage.entity.ItemsProjection;



public class CustomerOrderDTO {
	
	private Long id;

	private String customerName;

	private String customerMobile;

	private String mailId;
	
	private Date documentDate;

//	private String itemName;
//
//	private Long price;
//
//	private Long quantity;
//
//	private Long itemTotal;

	public Date getDocumentDate() {
		return documentDate;
	}


	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}


	private List<ItemsProjection> items;
	
	
	public CustomerOrderDTO(){}


	


	public CustomerOrderDTO(Long id, String customerName, String customerMobile, String mailId,
			Date documentDate, List<ItemsProjection> items) {
	
		this.id = id;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.mailId = mailId;
		this.documentDate = documentDate;
		this.items = items;
	}



	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerMobile() {
		return customerMobile;
	}


	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}


	public String getMailId() {
		return mailId;
	}


	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	


	public List<ItemsProjection> getItems() {
		return items;
	}


	public void setItems(List<ItemsProjection> items) {
		this.items = items;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "CustomerOrderDTO [id=" + id + ", customerName=" + customerName + ", customerMobile=" + customerMobile
				+ ", mailId=" + mailId + ", documentDate=" + documentDate + ", items=" + items + "]";
	}


	

	
	
	

	
	
}

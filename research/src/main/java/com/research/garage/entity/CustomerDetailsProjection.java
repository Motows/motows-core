package com.research.garage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;




@Entity
@Table(name ="customer_details")
@EntityListeners(AuditingEntityListener.class)


public class CustomerDetailsProjection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documentNo;
	
	private Date documentDate;
	
	private String customerName;
	
	private String customerMobile;
	
	private String mailId;

	
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE}, mappedBy = "customerDetails")  
	private List<ItemsProjection> items;
	
	
	
	public CustomerDetailsProjection() {
	
	}


	public CustomerDetailsProjection(Date documentDate, String customerName, String customerMobile,
			String mailId) {
		
		this.documentDate = documentDate;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.mailId = mailId;
	}










	public Long getDocumentNo() {
		return documentNo;
	}



	public void setDocumentNo(Long documentNo) {
		this.documentNo = documentNo;
	}



	public Date getDocumentDate() {
		return documentDate;
	}



	public void setDocumentDate(Date documentDate) {
	
		this.documentDate = documentDate;
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



	public void add(ItemsProjection theItems) {
		if(items==null) {
			items= new ArrayList<ItemsProjection>();
		}
		items.add(theItems);
		theItems.setCustomerDetails(this);
		
	}










	@Override
	public String toString() {
		return "CustomerDetailsProjection (documentNo=" + documentNo + ", documentDate=" + documentDate
				+ ", customerName=" + customerName + ", customerMobile=" + customerMobile + ", mailId=" + mailId
				+ ", items=" + items + ")";
	}
	

}

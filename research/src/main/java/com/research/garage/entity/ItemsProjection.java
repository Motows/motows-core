package com.research.garage.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="items")

public class ItemsProjection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String itemName;
	
	private Long price;
	
	private Long quantity;
	
	private Long itemTotal;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="documentNo")
	private CustomerDetailsProjection customerDetails;

	public ItemsProjection() {
		
	}

	

	public ItemsProjection(String itemName, Long price, Long quantity, Long itemTotal) {
		
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(Long itemTotal) {
		this.itemTotal = itemTotal;
	}

	public CustomerDetailsProjection getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetailsProjection customerDetails) {
		this.customerDetails = customerDetails;
	}

	@Override
	public String toString() {
		return "ItemsProjection [id=" + id + ", itemName=" + itemName + ", price=" + price + ", quantity=" + quantity
				+ ", itemTotal=" + itemTotal + ", customerDetails=" + customerDetails + "]";
	}


}

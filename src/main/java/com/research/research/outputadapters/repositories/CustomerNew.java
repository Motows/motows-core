package com.research.research.outputadapters.repositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer")
public class CustomerNew {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerID")
	private int id;
	
	@Column(name = "customerName")
	private String customerName;
	
	@Column(name = "customerName_Cap")
	private String customerName_Cap;
	
	@Column(name = "customerName_UI")
	private String customerName_UI;
	
	@Column(name = "org_id")
	private String org_id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "email_id")
	private String email_id;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "country_id")
	private String country_id;
	
	@Column(name = "state_id")
	private String state_id;
	
	@Column(name = "zipCodeId")
	private String zipCodeId;
	
	@Column(name = "mobile_no")
	private String mobile_no;
	
	@Column(name = "gstin")
	private String gstin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerName_Cap() {
		return customerName_Cap;
	}

	public void setCustomerName_Cap(String customerName_Cap) {
		this.customerName_Cap = customerName_Cap;
	}

	public String getCustomerName_UI() {
		return customerName_UI;
	}

	public void setCustomerName_UI(String customerName_UI) {
		this.customerName_UI = customerName_UI;
	}

	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_id) {
		this.state_id = state_id;
	}

	public String getZipCodeId() {
		return zipCodeId;
	}

	public void setZipCodeId(String zipCodeId) {
		this.zipCodeId = zipCodeId;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	
	
}

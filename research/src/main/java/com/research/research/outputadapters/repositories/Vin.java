package com.research.research.outputadapters.repositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_vin")
public class Vin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicleID")
	private int id;
	
	@Column(name = "vin_reg_no")
	private String vin_reg_no;
	
	@Column(name = "vin_no")
	private String vin_no;
	
	@Column(name = "model_id")
	private String model_id;
	
	@Column(name = "manufacture_year")
	private String manufacture_year;
	
	@Column(name = "color_id")
	private String color_id;
	
	@Column(name = "make_id")
	private String make_id;
	
	@Column(name = "vehiclenotes")
	private String vehiclenotes;
	
	@Column(name = "customerID")
	private int customerID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVin_reg_no() {
		return vin_reg_no;
	}

	public void setVin_reg_no(String vin_reg_no) {
		this.vin_reg_no = vin_reg_no;
	}

	public String getVin_no() {
		return vin_no;
	}

	public void setVin_no(String vin_no) {
		this.vin_no = vin_no;
	}

	public String getModel_id() {
		return model_id;
	}

	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}
	
	public void setMake_id(String make_id) {
		this.make_id = make_id;
	}

	public String getMake_id() {
		return make_id;
	}

	

	
	public String getManufacture_year() {
		return manufacture_year;
	}

	public void setManufacture_year(String manufacture_year) {
		this.manufacture_year = manufacture_year;
	}

	public String getColor_id() {
		return color_id;
	}

	public void setColor_id(String color_id) {
		this.color_id = color_id;
	}

	public String getVehiclenotes() {
		return vehiclenotes;
	}

	public void setVehiclenotes(String vehiclenotes) {
		this.vehiclenotes = vehiclenotes;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	

	
}

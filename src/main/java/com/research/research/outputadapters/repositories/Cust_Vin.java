package com.research.research.outputadapters.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Cust_Vin {
	
	CustomerNew customer=new CustomerNew();
	
	Vin vin=new Vin();

	public CustomerNew getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerNew customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cust_Vin [customer=" + customer + ", vin=" + vin + ", getCustomer()=" + getCustomer() + ", getVin()="
				+ getVin() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public Vin getVin() {
		return vin;
	}

	public void setVin(Vin vin) {
		this.vin = vin;
	}
	
	

	
	

	
	
}

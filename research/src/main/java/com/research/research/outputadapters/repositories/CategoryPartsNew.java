package com.research.research.outputadapters.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class CategoryPartsNew {
	
	private String category_name;
	
	List<PartsNew> parts=new ArrayList<PartsNew>();
	
	

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public List<PartsNew> getParts() {
		return parts;
	}

	public List<PartsNew> setParts(List<PartsNew> parts) {
		this.parts = parts;
		return parts;
	}
	
}

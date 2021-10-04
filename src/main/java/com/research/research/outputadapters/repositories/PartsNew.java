package com.research.research.outputadapters.repositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_parts")
public class PartsNew {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "part_id")
	private String part_id;
	
	@Column(name = "cat_id")
	private String cat_id;
	
	@Column(name = "category_name")
	private String category_name;
	
	@Column(name = "part_name")
	private String part_name;
	
	@Column(name = "part_desc")
	private String part_desc;
	
	@Column(name = "part_price")
	private int part_price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPart_id() {
		return part_id;
	}

	public void setPart_id(String part_id) {
		this.part_id = part_id;
	}

	public String getPart_name() {
		return part_name;
	}

	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}

	public String getPart_desc() {
		return part_desc;
	}

	public void setPart_desc(String part_desc) {
		this.part_desc = part_desc;
	}

	public int getPart_price() {
		return part_price;
	}

	public void setPart_price(int part_price) {
		this.part_price = part_price;
	}
	
	
	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	
	
	
}

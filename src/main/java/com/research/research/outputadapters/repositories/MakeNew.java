package com.research.research.outputadapters.repositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_make")
public class MakeNew {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "part_id")
	private String part_id;
	
	@Column(name = "make_id")
	private String make_id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getMake_id() {
		return make_id;
	}

	public void setMake_id(String make_id) {
		this.make_id = make_id;
	}

	public String getPart_id() {
		return part_id;
	}

	public void setPart_id(String part_id) {
		this.part_id = part_id;
	}
	
}

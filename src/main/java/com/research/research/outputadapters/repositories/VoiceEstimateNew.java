package com.research.research.outputadapters.repositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_voice_estimate")
public class VoiceEstimateNew {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "vehicle_id")
	private String vehicle_id;
	
	@Column(name = "voice_id")
	private String voice_id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getVoice_id() {
		return voice_id;
	}

	public void setVoice_id(String voice_id) {
		this.voice_id = voice_id;
	}

	
}

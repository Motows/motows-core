package com.research.research.outputadapters.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class EstimateSave {
	
	List<JobsEstimateNew> jobs=new ArrayList<JobsEstimateNew>();
	
	List<VoiceNew> voice=new ArrayList<VoiceNew>();
	
	List<PartsEstimateNew> parts=new ArrayList<PartsEstimateNew>();

	public List<JobsEstimateNew> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobsEstimateNew> jobs) {
		this.jobs = jobs;
	}

	public List<VoiceNew> getVoice() {
		return voice;
	}

	public void setVoice(List<VoiceNew> voice) {
		this.voice = voice;
	}

	public List<PartsEstimateNew> getParts() {
		return parts;
	}

	public void setParts(List<PartsEstimateNew> parts) {
		this.parts = parts;
	}
	
	

	
	
	
	

	
}

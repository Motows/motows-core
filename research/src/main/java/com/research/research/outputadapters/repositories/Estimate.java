package com.research.research.outputadapters.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Estimate {
	
	List<JobNew> jobs=new ArrayList<JobNew>();
	
	List<VoiceNew> voice=new ArrayList<VoiceNew>();
	
	List<PartsNew> parts=new ArrayList<PartsNew>();
	
	int total=0;

	public List<JobNew> getJobs() {
		return jobs;
	}

	public List<JobNew> setJobs(List<JobNew> jobs) {
		this.jobs = jobs;
		return jobs;
	}

	public List<VoiceNew> getVoice() {
		return voice;
	}
	
	public List<VoiceNew> setVoice(List<VoiceNew> voice) {
		// TODO Auto-generated method stub
		this.voice = voice;
		return voice;
		
	}
	
	public List<PartsNew> getParts() {
		return parts;
	}
	
	public List<PartsNew> setParts(List<PartsNew> parts) {
		// TODO Auto-generated method stub
		this.parts = parts;
		return parts;
		
	}

	public int setTotal(int total) {
		// TODO Auto-generated method stub
		this.total = total;
		return total;
	}
	
	public int getTotal() {
		// TODO Auto-generated method stub
		return total;
	}

	
	
	
	

	
}

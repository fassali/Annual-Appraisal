package com.ymagis.appraisal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Level implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLevel;
	@JsonIgnore
	private SoftSkill softSkill;

	private int degree;

	private String mean;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ApSoftSkill> apSoftSkills = new HashSet<>(0);

	public Level() {
	}


	public Level(int degree, String mean) {
		super();
		this.degree = degree;
		this.mean = mean;
	}


	public Long getIdLevel() {
		return idLevel;
	}

	public void setIdLevel(Long idLevel) {
		this.idLevel = idLevel;
	}

	public SoftSkill getSoftSkill() {
		return softSkill;
	}

	public void setSoftSkill(SoftSkill softSkill) {
		this.softSkill = softSkill;
	}



	public int getDegree() {
		return degree;
	}


	public void setDegree(int degree) {
		this.degree = degree;
	}


	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	public Set<ApSoftSkill> getApSoftSkills() {
		return apSoftSkills;
	}

	public void setApSoftSkills(Set<ApSoftSkill> apSoftSkills) {
		this.apSoftSkills = apSoftSkills;
	}
}

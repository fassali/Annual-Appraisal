package com.ymagis.appraisal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MEANING")
public class MeaningSkils {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMeaning;
	@Column(name = "LEVEL")
	private int level;
	@Column(name = "DESCRIPTION")
	private String desciption;
	@ManyToOne(cascade = {

			CascadeType.PERSIST,

			CascadeType.MERGE

	})
	@JsonIgnore
	@JoinColumn(name = "id_skils")
	private Skils skil;

	public long getIdMeaning() {
		return idMeaning;
	}

	public void setIdMeaning(long idMeaning) {
		this.idMeaning = idMeaning;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Skils getSkil() {
		return skil;
	}

	public void setSkil(Skils skil) {
		this.skil = skil;
	}

	public MeaningSkils() {
		super();
		// TODO Auto-generated constructor stub
	}

}

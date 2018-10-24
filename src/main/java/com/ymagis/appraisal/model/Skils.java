package com.ymagis.appraisal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SKILS")
public class Skils {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSkils;
	@Column(name = "LIBELLE")
	private String libelleSkils;
	@OneToMany(mappedBy = "skil", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<MeaningSkils> meaningSkils;

	public Long getIdSkils() {
		return idSkils;
	}

	public void setIdSkils(Long idSkils) {
		this.idSkils = idSkils;
	}

	public String getLibelleSkils() {
		return libelleSkils;
	}

	public void setLibelleSkils(String libelleSkils) {
		this.libelleSkils = libelleSkils;
	}

	public List<MeaningSkils> getMeaningSkils() {
		return meaningSkils;
	}

	public void setMeaningSkils(List<MeaningSkils> meaningSkils) {
		this.meaningSkils = meaningSkils;
	}

	public Skils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skils(String libelleSkils) {
		super();
		this.libelleSkils = libelleSkils;
	}

}

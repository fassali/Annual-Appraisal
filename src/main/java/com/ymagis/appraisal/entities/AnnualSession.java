package com.ymagis.appraisal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AnnualSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnn;

    private String label;

    private String status;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<ApSoftSkill> apSoftSkills = new HashSet<>(0);


    public AnnualSession(String label, String status, Set<ApSoftSkill> apSoftSkills) {
        this.label = label;
        this.status = status;
        this.apSoftSkills = apSoftSkills;
    }

    public AnnualSession() {
    }

    public Long getIdAnn() {
        return idAnn;
    }

    public void setIdAnn(Long idAnn) {
        this.idAnn = idAnn;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ApSoftSkill> getApSoftSkills() {
        return apSoftSkills;
    }

    public void setApSoftSkills(Set<ApSoftSkill> apSoftSkills) {
        this.apSoftSkills = apSoftSkills;
    }
}
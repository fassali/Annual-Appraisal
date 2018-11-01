package com.ymagis.appraisal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRating;

    private String code;

    private String label;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<ApHardSkill> apHardSkills = new HashSet<>(0);

    public Rating() {
    }

    public Rating(String code, String label, Set<ApHardSkill> apHardSkills) {
        this.code = code;
        this.label = label;
        this.apHardSkills = apHardSkills;
    }

    public Long getIdRating() {
        return idRating;
    }

    public void setIdRating(Long idRating) {
        this.idRating = idRating;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<ApHardSkill> getApHardSkills() {
        return apHardSkills;
    }

    public void setApHardSkills(Set<ApHardSkill> apHardSkills) {
        this.apHardSkills = apHardSkills;
    }
}

package com.ymagis.appraisal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class ApHardSkill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idApHdSkill;

    private ApEmploye apEmploye;

    private Rating rating;

    private String skill;

    private String mean;

    private String comment;

    public ApHardSkill() {
    }

    public ApHardSkill(Long idApHdSkill, ApEmploye apEmploye, Rating rating, String skill, String mean, String comment) {
        this.idApHdSkill = idApHdSkill;
        this.apEmploye = apEmploye;
        this.rating = rating;
        this.skill = skill;
        this.mean = mean;
        this.comment = comment;
    }

    public Long getIdApHdSkill() {
        return idApHdSkill;
    }

    public void setIdApHdSkill(Long idApHdSkill) {
        this.idApHdSkill = idApHdSkill;
    }

    public ApEmploye getApEmploye() {
        return apEmploye;
    }

    public void setApEmploye(ApEmploye apEmploye) {
        this.apEmploye = apEmploye;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

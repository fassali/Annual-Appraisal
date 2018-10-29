package com.ymagis.appraisal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ApObjEmp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idApObjEmp;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JsonIgnore
    @JoinColumn(name = "id_ap_emp")
    private ApEmploye apEmploye;

    private String indicator;

    private String labelObj;

    private String mean;

    private Date deadLine;

    public ApObjEmp() {
    }

    public ApObjEmp(Long idApObjEmp, ApEmploye apEmploye, String indicator, String labelObj, String mean, Date deadLine) {
        this.idApObjEmp = idApObjEmp;
        this.apEmploye = apEmploye;
        this.indicator = indicator;
        this.labelObj = labelObj;
        this.mean = mean;
        this.deadLine = deadLine;
    }

    public Long getIdApObjEmp() {
        return idApObjEmp;
    }

    public void setIdApObjEmp(Long idApObjEmp) {
        this.idApObjEmp = idApObjEmp;
    }

    public ApEmploye getApEmploye() {
        return apEmploye;
    }

    public void setApEmploye(ApEmploye apEmploye) {
        this.apEmploye = apEmploye;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getLabelObj() {
        return labelObj;
    }

    public void setLabelObj(String labelObj) {
        this.labelObj = labelObj;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }
}

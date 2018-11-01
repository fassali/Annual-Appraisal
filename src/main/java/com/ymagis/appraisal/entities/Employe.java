package com.ymagis.appraisal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmp;

    private String firstName;

    private String lastName;

    private String position;

    private String team;

    private Date dateEntry;

    private String mFistName;

    private String mLastName;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<ApEmploye> apEmployes = new HashSet<>(0);

    public Employe() {
    }

    public Employe(String firstName, String lastName, String position, String team, Date dateEntry, String mFistName, String mLastName, Set<ApEmploye> apEmployes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.team = team;
        this.dateEntry = dateEntry;
        this.mFistName = mFistName;
        this.mLastName = mLastName;
        this.apEmployes = apEmployes;
    }

    public Long getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Long idEmp) {
        this.idEmp = idEmp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Date getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Date dateEntry) {
        this.dateEntry = dateEntry;
    }

    public String getmFistName() {
        return mFistName;
    }

    public void setmFistName(String mFistName) {
        this.mFistName = mFistName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public Set<ApEmploye> getApEmployes() {
        return apEmployes;
    }

    public void setApEmployes(Set<ApEmploye> apEmployes) {
        this.apEmployes = apEmployes;
    }
}

package com.ymagis.appraisal.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class ApSoftSkill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idApStSkill;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JsonIgnore
    @JoinColumn(name = "id_fd_back")
    private AnnualSession annualSession;

    private Level level;

    private ApEmploye apEmploye;

    public ApSoftSkill() {
    }

    public Long getIdApStSkill() {
        return idApStSkill;
    }

    public void setIdApStSkill(Long idApStSkill) {
        this.idApStSkill = idApStSkill;
    }

    public AnnualSession getAnnualSession() {
        return annualSession;
    }

    public void setAnnualSession(AnnualSession annualSession) {
        this.annualSession = annualSession;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public ApEmploye getApEmploye() {
        return apEmploye;
    }

    public void setApEmploye(ApEmploye apEmploye) {
        this.apEmploye = apEmploye;
    }
}

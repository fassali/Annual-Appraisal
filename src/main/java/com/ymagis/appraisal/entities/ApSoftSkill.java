package com.ymagis.appraisal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class ApSoftSkill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idApStSkill;

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

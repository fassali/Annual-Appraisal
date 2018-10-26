package com.ymagis.appraisal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class ApFeedBack implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idApFdBach;

    private FeedBack feedBack;

    private ApEmploye apEmploye;

    private  String comment;

    public ApFeedBack() {
    }

    public ApFeedBack(FeedBack feedBack, ApEmploye apEmploye, String comment) {
        this.feedBack = feedBack;
        this.apEmploye = apEmploye;
        this.comment = comment;
    }

    public Long getIdApFdBach() {
        return idApFdBach;
    }

    public void setIdApFdBach(Long idApFdBach) {
        this.idApFdBach = idApFdBach;
    }

    public FeedBack getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(FeedBack feedBack) {
        this.feedBack = feedBack;
    }

    public ApEmploye getApEmploye() {
        return apEmploye;
    }

    public void setApEmploye(ApEmploye apEmploye) {
        this.apEmploye = apEmploye;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

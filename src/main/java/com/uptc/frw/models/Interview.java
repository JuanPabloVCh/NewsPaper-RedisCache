package com.uptc.frw.models;

import com.uptc.frw.models.enums.InvolvedStatus;
import com.uptc.frw.models.key.InterviewId;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "INTERVIEW")
public class Interview {
    @EmbeddedId
    private InterviewId id;

    @ManyToOne
    @MapsId("idJournalist")
    @JoinColumn(name = "ID_JOURNALIST")
    private Journalist journalist;

    @ManyToOne
    @MapsId("idReport")
    @JoinColumn(name = "ID_REPORT")
    private Report report;

    @ManyToOne
    @MapsId("idInvolved")
    @JoinColumn(name = "ID_INVOLVED")
    private Involved involved;

    @Column(name = "INTERVIEW_DATE")
    private Date interviewDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "INVOLVED_STATUS")
    private InvolvedStatus status;

    public Interview() {
    }

    public Interview(Journalist journalist, Report report, Involved involved, Date interviewDate, InvolvedStatus status) {
        this.journalist = journalist;
        this.report = report;
        this.involved = involved;
        this.interviewDate = interviewDate;
        this.status = status;
    }

    public InterviewId getId() {
        return id;
    }

    public void setId(InterviewId id) {
        this.id = id;
    }

    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Involved getInvolved() {
        return involved;
    }

    public void setInvolved(Involved involved) {
        this.involved = involved;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public InvolvedStatus getStatus() {
        return status;
    }

    public void setStatus(InvolvedStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", interviewDate=" + interviewDate +
                ", status=" + status +
                '}';
    }
}
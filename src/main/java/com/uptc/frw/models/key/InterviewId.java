package com.uptc.frw.models.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InterviewId implements Serializable {
    private Long idJournalist;
    private Long idReport;
    private Long idInvolved;

    public InterviewId() {
    }

    public InterviewId(Long idJournalist, Long idReport, Long idInvolved) {
        this.idJournalist = idJournalist;
        this.idReport = idReport;
        this.idInvolved = idInvolved;
    }

    public Long getIdJournalist() {
        return idJournalist;
    }

    public void setIdJournalist(Long idJournalist) {
        this.idJournalist = idJournalist;
    }

    public Long getIdReport() {
        return idReport;
    }

    public void setIdReport(Long idReport) {
        this.idReport = idReport;
    }

    public Long getIdInvolved() {
        return idInvolved;
    }

    public void setIdInvolved(Long idInvolved) {
        this.idInvolved = idInvolved;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InterviewId that = (InterviewId) o;
        return Objects.equals(idJournalist, that.idJournalist) && Objects.equals(idReport, that.idReport) && Objects.equals(idInvolved, that.idInvolved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJournalist, idReport, idInvolved);
    }
}

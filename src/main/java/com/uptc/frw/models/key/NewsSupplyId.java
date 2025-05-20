package com.uptc.frw.models.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NewsSupplyId implements Serializable {
    private Long idReport;
    private Long idAgency;

    public NewsSupplyId(Long idReport, Long idAgency) {
        this.idReport = idReport;
        this.idAgency = idAgency;
    }

    public NewsSupplyId() {
    }

    public Long getIdReport() {
        return idReport;
    }

    public void setIdReport(Long idReport) {
        this.idReport = idReport;
    }

    public Long getIdAgency() {
        return idAgency;
    }

    public void setIdAgency(Long idAgency) {
        this.idAgency = idAgency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NewsSupplyId that = (NewsSupplyId) o;
        return Objects.equals(idReport, that.idReport) && Objects.equals(idAgency, that.idAgency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReport, idAgency);
    }
}

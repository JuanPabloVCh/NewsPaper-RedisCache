package com.uptc.frw.models;

import com.uptc.frw.models.key.NewsSupplyId;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "NEWS_SUPPLY")
public class NewsSupply {

    @EmbeddedId
    private NewsSupplyId id;

    @ManyToOne
    @MapsId("idReport")
    @JoinColumn(name = "ID_REPORT")
    private Report report;

    @ManyToOne
    @MapsId("idAgency")
    @JoinColumn(name = "ID_AGENCY")
    private Agency agency;

    @Column(name = "NEW_SUPPLY_DATE")
    private Date supplyDate;

    public NewsSupply() {
    }

    public NewsSupply(Report report, Agency agency, Date supplyDate) {
        this.report = report;
        this.agency = agency;
        this.supplyDate = supplyDate;
    }

    public NewsSupplyId getId() {
        return id;
    }

    public void setId(NewsSupplyId id) {
        this.id = id;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Date getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(Date supplyDate) {
        this.supplyDate = supplyDate;
    }

    @Override
    public String toString() {
        return "NewsSupply{" +
                "id=" + id +
                ", supplyDate=" + supplyDate +
                '}';
    }
}

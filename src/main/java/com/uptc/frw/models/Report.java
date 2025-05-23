package com.uptc.frw.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.RedisHash;
import org.hibernate.annotations.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "REPORT")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Report implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReport;

    @ManyToOne
    @JoinColumn(name = "ID_REPORT_RELATED")
    private Report relatedReport;

    @Column(name = "REPORT_DATE")
    private Date reportDate;

    @Column(name = "REPORT_TITLE")
    private String title;

    @Column(name = "REPORT_TEXT")
    private String text;

    @OneToMany(mappedBy = "report")
    private List<NewsSupply> newsSupplies = new ArrayList<>();

    public Report() {
    }

    public Report(Report relatedReport, Date reportDate, String title, String text) {
        this.relatedReport = relatedReport;
        this.reportDate = reportDate;
        this.title = title;
        this.text = text;
    }

    public Report(Date reportDate, String title, String text) {
        this.reportDate = reportDate;
        this.title = title;
        this.text = text;
    }

    public Long getIdReport() {
        return idReport;
    }

    public void setIdReport(Long idReport) {
        this.idReport = idReport;
    }

    public Report getRelatedReport() {
        return relatedReport;
    }

    public void setRelatedReport(Report relatedReport) {
        this.relatedReport = relatedReport;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<NewsSupply> getNewsSupplies() {
        return newsSupplies;
    }

    public void setNewsSupplies(List<NewsSupply> newsSupplies) {
        this.newsSupplies = newsSupplies;
    }

    @Override
    public String toString() {
        return "Report{" +
                "idReport=" + idReport +
                ", reportDate=" + reportDate +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

package com.uptc.frw.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "AGENCY")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgency;

    private String name;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    public Agency() {
    }

    public Agency(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public Long getIdAgency() {
        return idAgency;
    }

    public void setIdAgency(Long idAgency) {
        this.idAgency = idAgency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "idAgency=" + idAgency +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}

package com.uptc.frw.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "JOURNALIST")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Journalist implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJournalist;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "COVERED_NEW",
            joinColumns = @JoinColumn(name = "ID_JOURNALIST"),
            inverseJoinColumns = @JoinColumn(name = "ID_REPORT")
    )
    @JsonIgnore
    private List<Report> coveredReports = new ArrayList<Report>();

    public Journalist() {
    }

    public Journalist(String name, String address, String email, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getIdJournalist() {
        return idJournalist;
    }

    public void setIdJournalist(Long idJournalist) {
        this.idJournalist = idJournalist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Report> getCoveredReports() {
        return coveredReports;
    }

    public void setCoveredReports(List<Report> coveredReports) {
        this.coveredReports = coveredReports;
    }

    @Override
    public String toString() {
        return "Journalist{" +
                "idJournalist=" + idJournalist +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

package com.uptc.frw.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "JOURNALIST")
public class Journalist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJournalist;

    private String name;
    private String address;
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "COVERED_NEW",
            joinColumns = @JoinColumn(name = "ID_JOURNALIST"),
            inverseJoinColumns = @JoinColumn(name = "ID_REPORT")
    )
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

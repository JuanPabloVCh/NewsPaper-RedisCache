package com.uptc.frw.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "INVOLVED")
public class Involved {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInvolved;

    private String name;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    public Involved() {
    }

    public Involved(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getIdInvolved() {
        return idInvolved;
    }

    public void setIdInvolved(Long idInvolved) {
        this.idInvolved = idInvolved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Involved{" +
                "idInvolved=" + idInvolved +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

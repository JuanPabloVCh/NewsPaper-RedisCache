package com.uptc.frw.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.redis.core.RedisHash;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "INVOLVED")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Involved implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInvolved;

    @Column(name = "NAME")
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

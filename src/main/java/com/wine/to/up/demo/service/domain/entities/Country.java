package com.wine.to.up.demo.service.domain.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Countries")
@Data
public class Country {
    @Id
    @Column(name = "countryID", nullable = false)
    private int countryID;

    @Column(name = "countryName")
    private String countryName;
}

package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Countries")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countryID", nullable = false)
    private int countryID;

    @Column(name = "countryName")
    private String countryName;
}

package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PositionPrice")
@Data
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "priceID", nullable = false)
    private int priceID;

    @Column(name = "wineID")
    private String wineID;

    @Column(name = "shopID")
    private String shopID;

    @Column(name = "value")
    private float value;
}

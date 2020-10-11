package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Catalog")
@Data
public class Catalog {
    @Column(name = "wineID", nullable = false)
    private String wineID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "winePositionID")
    private int winePositionID;

    @ManyToOne
    @JoinColumn(name = "shopID", nullable = false)
    private Shop shopID;

    @Column(name = "price")
    private int price;
}
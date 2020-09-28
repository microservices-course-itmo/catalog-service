package com.wine.to.up.demo.service.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Catalog")
@Data
public class Catalog {
    @Column(name = "wineID", nullable = false)
    private int wineID;

    @Id
    @Column(name = "winePositionID")
    private int winePositionID;

    @Column(name = "shopID", nullable = false)
    private int shopID;

    @Column(name = "price")
    private int price;
}

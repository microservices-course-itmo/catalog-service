package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "wine_position")
@Data
public class WinePosition {
    @Id
    @Column(name = "id", nullable = false)
    private String wpId;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "wine_id", nullable = false)
    private Wine wpWine;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @Column(name = "price")
    private float price;

    @Column(name = "actual_price", nullable = false)
    private float actualPrice;

    @Column(name = "link_to_wine")
    private String linkToWine;

    @Column(name = "volume")
    private float volume;

    @Column(name = "description")
    private String description;

    @Column(name = "gastronomy")
    private String gastronomy;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "city")
    private String city;

    @Column(name = "items_in_stock")
    private Integer itemsInStock;
}
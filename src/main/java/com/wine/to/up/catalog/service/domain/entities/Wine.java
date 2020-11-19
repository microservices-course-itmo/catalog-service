package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wine")
@Data
public class Wine {
    @Id
    @Column(name = "id", nullable = false)
    private String wineID;

    @Column(name = "name", nullable = false)
    private String wineName;

    @ManyToOne
    @JoinColumn(name = "producer_id", nullable = false)
    private Producer wineProducer;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand wineBrand;

    @ManyToMany
    @JoinTable(
            name = "wineRegion",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "region_id"))
    private List<Region> wineRegion;

    @ManyToMany
    @JoinTable(
            name = "wineGrape",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "grape_id"))
    private List<Grape> wineGrape;

    @Column(name = "avg", nullable = false)
    private float strength;

    @Column(name = "year", nullable = false)
    private int production_year;

    @ManyToOne
    @Column(name = "color_id", nullable = false)
    private Color wineColor;

    @ManyToOne
    @Column(name = "sugar_id", nullable = false)
    private Sugar wineSugar;

    @OneToMany(mappedBy = "wpWine")
    private List<WinePosition> winePositions;

}
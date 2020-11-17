package com.wine.to.up.catalog.service.domain.entities;

import com.wine.to.up.catalog.service.domain.enums.Color;
import com.wine.to.up.catalog.service.domain.enums.Sugar;
import com.wine.to.up.catalog.service.converters.ColorConverter;
import com.wine.to.up.catalog.service.converters.SugarConverter;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wine")
@Data
@TypeDef(name="colorConverter", typeClass= ColorConverter.class)
@TypeDef(name="sugarConverter", typeClass= SugarConverter.class)
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

    @Type(type="colorConverter")
    @Column(name = "color", nullable = false)
    private Color wineColor;

    @Type(type="sugarConverter")
    @Column(name = "sugar", nullable = false)
    private Sugar wineSugar;

    @OneToMany(mappedBy = "wpWine")
    private List<WinePosition> winePositions;

}
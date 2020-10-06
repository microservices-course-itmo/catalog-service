package com.wine.to.up.catalog.service.domain.entities;

import com.wine.to.up.catalog.service.domain.enums.Color;
import com.wine.to.up.catalog.service.domain.enums.Sugar;
import com.wine.to.up.catalog.service.converters.ColorConverter;
import com.wine.to.up.catalog.service.converters.SugarConverter;
import lombok.Data;
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
    private int wineID;

    @Column(name = "name", nullable = false)
    private String wineName;

    @ManyToOne
    @JoinColumn(name = "producer_id", nullable = false)
    private Producer wineProducer;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand wineBrand;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region wineRegion;

    @ManyToOne
    @JoinColumn(name = "grape_id", nullable = false)
    private Grape wineGrape;

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

    @OneToMany(mappedBy = "reviewWine")
    private List<Review> wineReviews;
}
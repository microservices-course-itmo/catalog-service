package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "region")
@Data
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String regionID;

    @Column(name = "name")
    private String regionName;

    @Column(name = "country")
    private String regionCountry;

    @OneToMany(mappedBy = "wineRegion")
    private List<Wine> regionWines;
}

package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "WineGrapesInfo")
@Data
public class WineGrapesInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "wineID", nullable = false)
    private String wineID;

    @Column(name = "grapeID", nullable = false)
    private String grapeID;
}
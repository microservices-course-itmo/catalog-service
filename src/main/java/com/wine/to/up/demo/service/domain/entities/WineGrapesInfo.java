package com.wine.to.up.demo.service.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "WineGrapesInfo")
@Data
public class WineGrapesInfo {
    @Id
    @Column(name = "wineID", nullable = false)
    private int wineID;

    @Column(name = "grapeID", nullable = false)
    private int grapeID;
}
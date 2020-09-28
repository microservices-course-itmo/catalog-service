package com.wine.to.up.demo.service.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WineGrapesInfo")
@Data
public class WineGrapesInfo {
    @Id
    @Column(name = "wineID", nullable = false)
    private int wineID;

    @OneToMany
    @JoinColumn(name = "grapeID", nullable = false)
    private List<Grapes> grapesId = new ArrayList<>();
}

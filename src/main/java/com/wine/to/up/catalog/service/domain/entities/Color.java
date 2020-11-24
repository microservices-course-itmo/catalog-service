package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "color")
@Data
public class Color {
    @Id
    @Column(name = "id", nullable = false)
    private String colorID;

    @Column(name = "name")
    private String colorName;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "wineColor")
    private List<Wine> colorWines;
}

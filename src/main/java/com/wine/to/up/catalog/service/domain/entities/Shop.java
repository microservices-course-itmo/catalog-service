package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
@Data
public class Shop {
    @Id
    @Column(name = "id", nullable = false)
    private String shopID;

    @Column(name = "site", nullable = false)
    private String shopSite;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "shop")
    private List<WinePosition> winePositions;
}

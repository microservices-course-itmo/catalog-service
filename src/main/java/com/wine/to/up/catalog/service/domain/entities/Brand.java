package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Brands")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brandID", nullable = false)
    private int brandID;

    @Column(name = "brandName")
    private String brandName;
}

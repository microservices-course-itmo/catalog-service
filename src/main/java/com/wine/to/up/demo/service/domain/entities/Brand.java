package com.wine.to.up.demo.service.domain.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Brands")
@Data
public class Brand {
    @Id
    @Column(name = "brandID", nullable = false)
    private int brandID;

    @Column(name = "brandName")
    private String brandName;
}

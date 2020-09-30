package com.wine.to.up.demo.service.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Shops")
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopID", nullable = false)
    private int shopID;

    @Column(name = "shopName", nullable = false)
    private String shopName;
}

package com.wine.to.up.demo.service.domain.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shops")
@Data
public class Shop {
    @Id
    @Column(name = "shopID", nullable = false)
    private int shopID;

    @Column(name = "shopName", nullable = false)
    private String shopName;
}

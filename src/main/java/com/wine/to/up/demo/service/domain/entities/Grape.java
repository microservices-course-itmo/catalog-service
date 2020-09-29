package com.wine.to.up.demo.service.domain.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Grapes")
@Data
public class Grape {
    @Id
    @Column(name = "grapeID", nullable = false)
    private int id;

    @Column(name = "grapesName")
    private String grapesName;
}

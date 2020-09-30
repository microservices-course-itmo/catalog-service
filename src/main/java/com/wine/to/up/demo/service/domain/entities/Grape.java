package com.wine.to.up.demo.service.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Grapes")
@Data
public class Grape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grapeID", nullable = false)
    private int id;

    @Column(name = "grapesName")
    private String grapesName;
}

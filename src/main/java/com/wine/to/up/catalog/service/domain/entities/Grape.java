package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Grapes")
@Data
public class Grape {
    @Id
    @Column(name = "grapeID", nullable = false)
    private String id;

    @Column(name = "grapeName")
    private String grapesName;

    @Column(name = "grapeCode")
    private String code;


}

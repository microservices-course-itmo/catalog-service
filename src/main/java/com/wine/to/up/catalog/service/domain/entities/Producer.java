package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int producerID;

    @Column(name = "name")
    private String producerName;

    @OneToMany(mappedBy = "wineProducer")
    private List<Wine> producerWines;
}

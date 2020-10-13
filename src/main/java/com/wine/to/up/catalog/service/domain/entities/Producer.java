package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "producer")
public class Producer {
    @Id
    @Column(name = "id", nullable = false)
    private String producerID;

    @Column(name = "name")
    private String producerName;

    @OneToMany(mappedBy = "wineProducer")
    private List<Wine> producerWines;
}

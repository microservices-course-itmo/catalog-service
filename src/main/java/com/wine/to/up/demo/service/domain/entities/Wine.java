package com.wine.to.up.demo.service.domain.entities;

import com.wine.to.up.demo.service.domain.enums.Color;
import com.wine.to.up.demo.service.domain.enums.Sugar;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Wine")
@Data
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wineID", nullable = false)
    private int wineID;

    @Column(name = "picture", nullable = false)
    private byte[] picture;

    @ManyToOne()
    @JoinColumn(name = "brandID", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "countryID", nullable = false)
    private Country country;

    @Column(name = "volume", nullable = false)
    private float volume;

    @Column(name = "abv", nullable = false)
    private float strength;

    @Column(name = "color", nullable = false)
    private Color color;

    @Column(name = "sugar", nullable = false)
    private Sugar sugar;
}

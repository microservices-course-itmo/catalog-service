package com.wine.to.up.catalog.service.domain.entities;

import com.wine.to.up.catalog.service.domain.enums.Color;
import com.wine.to.up.catalog.service.domain.enums.Sugar;
import com.wine.to.up.catalog.service.converters.ColorConverter;
import com.wine.to.up.catalog.service.converters.SugarConverter;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Table(name = "Wine")
@Data
@TypeDef(name="colorConverter", typeClass= ColorConverter.class)
@TypeDef(name="sugarConverter", typeClass= SugarConverter.class)
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wineID", nullable = false)
    private int wineID;

    @Column(name = "picture", nullable = false)
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "brandid", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "countryID", nullable = false)
    private Country country;

    @Column(name = "volume", nullable = false)
    private float volume;

    @Column(name = "abv", nullable = false)
    private float strength;

    @Type(type="colorConverter")
    @Column(name = "color", nullable = false)
    private Color color;

    @Type(type="sugarConverter")
    @Column(name = "sugar", nullable = false)
    private Sugar sugar;
}

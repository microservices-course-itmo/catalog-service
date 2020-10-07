package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "review")
@Data
public class Review {
    @Id
    @Column(name = "wine_id")
    private String wineID;

    @Column(name = "user_id")
    private int userID;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "text")
    private String text;

    @Column(name = "mark")
    private float mark;

    @ManyToOne
    @JoinColumn(name = "wine_id")
    private Wine reviewWine;
}

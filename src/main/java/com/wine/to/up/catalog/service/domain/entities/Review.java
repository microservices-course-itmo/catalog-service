package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Data
public class Review {
    @EmbeddedId
    private ReviewID reviewID;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "text")
    private String text;

    @Column(name = "mark")
    private float mark;

}

package com.wine.to.up.catalog.service.domain.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ReviewID implements Serializable {
    @Column(name = "wine_id", nullable = false)
    private String wineID;

    @Column(name = "user_id")
    private int userID;
}

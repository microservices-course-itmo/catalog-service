package com.wine.to.up.catalog.service.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class WineDTO {
    private String id;

    private String name;

    private String producer_id;

    private String brand_id;

    private String region_id;

    private String grape_id;

    private float avg;

    private String color;

    private String sugar;

    private int year;
}

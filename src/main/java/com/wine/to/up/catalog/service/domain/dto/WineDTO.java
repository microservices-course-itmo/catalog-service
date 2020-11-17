package com.wine.to.up.catalog.service.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class WineDTO {
    private String id;

    private String name;

    private String producer_id;

    private String brand_id;

    private List<String> region_id;

    private List<String> grape_id;

    private float avg;

    private String color;

    private String sugar;

    private int year;
}

package com.wine.to.up.catalog.service.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WineDTO {
    private String id;

    private String name;

    private Integer price;

    private String production_year;

    private String production_country;

    private String sugar_content;

    private String discount_info;

    private String wine_chars;

    private float strength;

    private float volume;

    private String color;

    private String brand;

    private List<Byte> picture;

    private List<String> grapes_info;
}

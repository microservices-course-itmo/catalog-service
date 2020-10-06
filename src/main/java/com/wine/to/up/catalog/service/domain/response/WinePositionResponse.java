package com.wine.to.up.catalog.service.domain.response;

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
public class WinePositionResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("production_year")
    private String production_year;

    @JsonProperty("production_country")
    private String production_country;

    @JsonProperty("sugar_content")
    private String sugar_content;

    @JsonProperty("discount_info")
    private String discount_info;

    @JsonProperty("wine_chars")
    private String wine_chars;

    @JsonProperty("strength")
    private float strength;

    @JsonProperty("volume")
    private float volume;

    @JsonProperty("color")
    private String color;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("picture")
    private List<Byte> picture;

    @JsonProperty("grapes_info")
    private List<String> grapes_info;


}

package com.wine.to.up.catalog.service.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WinePositionResponse {

    @JsonProperty("wine_position_id")
    private String wine_position_id;

    @JsonProperty("wine_id")
    private String wine_id;

    @JsonProperty("shop_id")
    private String shop_id;

    @JsonProperty("price")
    private float price;

    @JsonProperty("actual_price")
    private float actual_price;

    @JsonProperty("link_to_wine")
    private String link_to_wine;

    @JsonProperty("volume")
    private float volume;

    @JsonProperty("description")
    private String description;

    @JsonProperty("gastronomy")
    private String gastronomy;

    @JsonProperty("image")
    private List<Byte> image;

    @JsonProperty("itemsInStock")
    private Integer itemsInStock;

    @JsonProperty("city")
    private String city;
}
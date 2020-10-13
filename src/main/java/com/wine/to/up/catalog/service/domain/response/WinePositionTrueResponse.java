package com.wine.to.up.catalog.service.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wine.to.up.catalog.service.domain.request.WineTrueRequest;

import java.util.List;

public class WinePositionTrueResponse {
    @JsonProperty("wine_position_id")
    private String wine_position_id;

    @JsonProperty("shop_id")
    private int shop_id;

    @JsonProperty("wine")
    private WineTrueResponse wineTrueResponse;

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
}

package com.wine.to.up.catalog.service.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WinePositionTrueRequest {
    @JsonProperty("shop_id")
    private int shop_id;

    @JsonProperty("wine")
    private WineTrueRequest wineTrueRequest;

    @JsonProperty("price")
    private double price;

    @JsonProperty("actual_price")
    private double actual_price;

    @JsonProperty("link_to_wine")
    private String link_to_wine;

    @JsonProperty("volume")
    private double volume;

    @JsonProperty("description")
    private String description;

    @JsonProperty("gastronomy")
    private String gastronomy;

    @JsonProperty("image")
    private List<Byte> image;
}

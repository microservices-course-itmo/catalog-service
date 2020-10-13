package com.wine.to.up.catalog.service.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WineTrueResponse {
    @JsonProperty("wine_id")
    private String wine_id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("producer")
    private ProducerResponse producerResponse;

    @JsonProperty("brand")
    private BrandResponse brandResponse;

    @JsonProperty("region")
    private RegionResponse regionResponse;

    @JsonProperty("grape")
    private GrapeResponse grapeResponse;

    @JsonProperty("avg")
    private float avg;

    @JsonProperty("color")
    private String color;

    @JsonProperty("sugar")
    private String sugar;

    @JsonProperty("year")
    private int year;
}

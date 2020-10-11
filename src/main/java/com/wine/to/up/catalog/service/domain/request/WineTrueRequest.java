package com.wine.to.up.catalog.service.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WineTrueRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("producer")
    private ProducerRequest producerRequest;

    @JsonProperty("brand")
    private BrandRequest brandRequest;

    @JsonProperty("region")
    private RegionRequest regionRequest;

    @JsonProperty("grape")
    private GrapeRequest grapeRequest;

    @JsonProperty("avg")
    private double avg;

    @JsonProperty("color")
    private String color;

    @JsonProperty("sugar")
    private String sugar;

    @JsonProperty("year")
    private int year;
}

package com.wine.to.up.catalog.service.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WineTrueRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("producer")
    private ProducerRequest producerRequest;

    @JsonProperty("brand")
    private BrandRequest brandRequest;

    @JsonProperty("region")
    private List<RegionRequest> regionRequest;

    @JsonProperty("grape")
    private List<GrapeRequest> grapeRequest;

    @JsonProperty("avg")
    private float avg;

    @JsonProperty("color")
    private String color;

    @JsonProperty("sugar")
    private String sugar;

    @JsonProperty("year")
    private int year;
}

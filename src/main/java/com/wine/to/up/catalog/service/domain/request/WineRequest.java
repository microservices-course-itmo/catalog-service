package com.wine.to.up.catalog.service.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WineRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("producer_id")
    private int producer_id;

    @JsonProperty("brand_id")
    private int brand_id;

    @JsonProperty("region_id")
    private int region_id;

    @JsonProperty("grape_id")
    private int grape_id;

    @JsonProperty("avg")
    private double avg;

    @JsonProperty("color")
    private String color;

    @JsonProperty("sugar")
    private String sugar;

    @JsonProperty("year")
    private int year;
}

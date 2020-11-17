package com.wine.to.up.catalog.service.domain.request;

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
public class WineRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("producer_id")
    private String producer_id;

    @JsonProperty("brand_id")
    private String brand_id;

    @JsonProperty("region_id")
    private List<String> region_id;

    @JsonProperty("grape_id")
    private List<String> grape_id;

    @JsonProperty("avg")
    private float avg;

    @JsonProperty("color")
    private String color;

    @JsonProperty("sugar")
    private String sugar;

    @JsonProperty("year")
    private int year;
}

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
public class RegionRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("country")
    private String country;
}

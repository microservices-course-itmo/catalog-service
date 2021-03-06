package com.wine.to.up.catalog.service.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KafkaWineRequest {
    @JsonProperty("id")
    private String wineId;

    @JsonProperty("name")
    private String wineName;

    @JsonProperty("price")
    private double price;
}

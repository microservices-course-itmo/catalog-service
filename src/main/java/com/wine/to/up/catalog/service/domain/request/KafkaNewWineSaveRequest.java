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
public class KafkaNewWineSaveRequest {
    @JsonProperty("id")
    private String wineId;

    @JsonProperty("name")
    private String wineName;

    @JsonProperty("description")
    private String wineDescription;
}
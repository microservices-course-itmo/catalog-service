package com.wine.to.up.catalog.service.domain.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProducerResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}

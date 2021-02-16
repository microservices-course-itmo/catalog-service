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
public class SettingsTrueRequest {
    @JsonProperty("page")
    private int page;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("sortBy")
    private List<SortByRequest> sortBy;

    @JsonProperty("filterBy")
    private String filterParameter;
}

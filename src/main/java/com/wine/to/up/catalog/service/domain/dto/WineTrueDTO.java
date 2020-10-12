package com.wine.to.up.catalog.service.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WineTrueDTO {
    private String wine_id;

    private String name;

    private ProducerDTO producerDTO;

    private BrandDTO brandDTO;

    private RegionDTO regionDTO;

    private GrapeDTO grapeDTO;

    private float avg;

    private String color;

    private String sugar;

    private int year;
}

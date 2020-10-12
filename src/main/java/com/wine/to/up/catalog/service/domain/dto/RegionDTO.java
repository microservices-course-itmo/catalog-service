package com.wine.to.up.catalog.service.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegionDTO {
    private String id;
    private String name;
    private String country;
}

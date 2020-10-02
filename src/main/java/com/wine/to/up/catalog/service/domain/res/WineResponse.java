package com.wine.to.up.catalog.service.domain.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WineResponse {
    private String id;

    private byte[] picture;

    private BrandResponse brand;

    private CountryResponse country;

    private String volume;

    private String strength;

    private String color;

    private String sugar;
}

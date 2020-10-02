package com.wine.to.up.catalog.service.domain.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class WineRequest {
    private String id;

    private byte[] picture;

    private BrandRequest brand;

    private CountryRequest country;

    private String volume;

    private String strength;

    private String color;

    private String sugar;
}

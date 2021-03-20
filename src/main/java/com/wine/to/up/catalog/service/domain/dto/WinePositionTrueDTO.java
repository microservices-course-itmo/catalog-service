package com.wine.to.up.catalog.service.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class WinePositionTrueDTO {
    private String wine_position_id;

    private String shop_id;

    private WineTrueDTO wineTrueDTO;

    private float price;

    private float actual_price;

    private String link_to_wine;

    private float volume;

    private String description;

    private String gastronomy;

    private List<Byte> image;

    private int itemsInStock;

    private String city;

}

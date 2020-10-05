package com.wine.to.up.catalog.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DiscountDTO {
    private String id;

    private String size;

    private String wine_position_id;

    private String source;
}

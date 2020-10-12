package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.dto.ShopDTO;
import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.ShopRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.domain.response.ShopResponse;
import org.springframework.stereotype.Component;

@Component
public class ShopControllerToShopService {
    public ShopDTO convert(ShopRequest shopRequest) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setSite(shopRequest.getSite());
        return shopDTO;
    }

    public ShopResponse convert(ShopDTO shopDTO)
    {
        ShopResponse shopResponse = new ShopResponse();
        shopResponse.setSite(shopDTO.getSite());
        shopResponse.setId(shopDTO.getId());
        return shopResponse;
    }
}

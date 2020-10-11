package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.request.GrapeRequest;
import com.wine.to.up.catalog.service.domain.request.ShopRequest;
import com.wine.to.up.catalog.service.domain.response.GrapeResponse;
import com.wine.to.up.catalog.service.domain.response.ShopResponse;
import org.springframework.stereotype.Component;

@Component
public class ShopControllerToShopService {
    public void convert(ShopRequest shopRequest) {
    }

    public ShopResponse convert() {
        return new ShopResponse();
    }
}

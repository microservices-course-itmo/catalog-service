package com.wine.to.up.catalog.service.mapper.controller2service;

import com.wine.to.up.catalog.service.domain.request.WineRequest;
import com.wine.to.up.catalog.service.domain.response.WineResponse;
import org.springframework.stereotype.Component;

@Component
public class WineControllerToWineService {
    public void convert(WineRequest wineRequest) {
    }

    public WineResponse convert() {
        return new WineResponse();
    }

}
